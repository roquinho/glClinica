
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Cargos;
import br.gl.glClinica.persistencia.InterfaceRepositorioCargos;
import br.gl.glClinica.regraNegocioException.ExceptionCargosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionCargosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioCargos implements InterfaceRegraNegocioCargos {

    @Autowired
    private InterfaceRepositorioCargos repositorioCargos;    
  
    
    @Override
    public void cadastrarCargo(Cargos cargo) throws ExceptionCargosEscrita {
        
        if(cargo == null) {
            throw new ExceptionCargosEscrita();
        }
        if(cargo.getNomeCargo() == null) {
            throw new ExceptionCargosEscrita();
        }
        if(cargo.getDescricaoCargo() == null) {
            throw new ExceptionCargosEscrita();
        }
        else {
            this.repositorioCargos.save(cargo);
        }     
        
    }

    @Override
    public void atualizarCargo(Cargos cargo) throws ExceptionCargosEscrita {
        
        if(cargo == null) {
            throw new ExceptionCargosEscrita();
        }
        if(cargo.getNomeCargo() == null) {
            throw new ExceptionCargosEscrita();
        }
        if(cargo.getDescricaoCargo() == null) {
            throw new ExceptionCargosEscrita();
        }
        if(cargo.getCodigoCargo() <= 0) {
            throw new ExceptionCargosEscrita();
        }
        if(this.repositorioCargos.exists(cargo.getCodigoCargo())==false) {
            throw new ExceptionCargosEscrita();
        }
        else {            
         Cargos novoCargo = this.repositorioCargos.findByCodigoCargo(cargo.getCodigoCargo());
            
            novoCargo.setDescricaoCargo(cargo.getDescricaoCargo());
            novoCargo.setNomeCargo(cargo.getNomeCargo());
            
               this.repositorioCargos.save(novoCargo);
        }
    }

    @Override
    public void deletarCargo(int codigoCargo) throws ExceptionCargosEscrita {
       
        if(codigoCargo <= 0){
            throw new ExceptionCargosEscrita();
        }
        if(this.repositorioCargos.exists(codigoCargo)==false) {
            throw new ExceptionCargosEscrita();
        }
        else {
            this.repositorioCargos.delete(codigoCargo);
        }
           
    }

    @Override
    public List<Cargos> listarCargos() throws ExceptionCargosLeitura {
        
       return this.repositorioCargos.findAll();
    }

    @Override
    public Cargos filtrarCargoCodigo(int codigoCargo) throws ExceptionCargosLeitura {
       
        if(codigoCargo <= 0) {
            throw new ExceptionCargosLeitura();
        }
        else {
          return this.repositorioCargos.findByCodigoCargo(codigoCargo);
        }
        
    }

    @Override
    public List<Cargos> filtrarCargoNome(String nomeCargo) throws ExceptionCargosLeitura {
        
        if(nomeCargo == null) {
            throw new ExceptionCargosLeitura();
        }
        else {
            return this.repositorioCargos.findByNomeCargoStartingWith(nomeCargo);
        }
        
    }

    public InterfaceRepositorioCargos getRepositorioCargos() {
        return repositorioCargos;
    }

    public void setRepositorioCargos(InterfaceRepositorioCargos repositorioCargos) {
        this.repositorioCargos = repositorioCargos;
    }
    
}
