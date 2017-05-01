
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioTiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioTiposConsultas implements InterfaceRegraNegocioTiposConsultas {

    @Autowired
    private InterfaceRepositorioTiposConsultas repositorioTiposConsultas;


    
    @Override
    public void cadastrarTipoConsulta(TiposConsultas tipoConsulta) throws ExceptionTiposConsultasEscrita {
       
        if(tipoConsulta == null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tipoConsulta.getNomeTipoConsulta()== null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tipoConsulta.getValorTipoConsulta() <0) {
           throw new ExceptionTiposConsultasEscrita();
        }
        else {
            this.repositorioTiposConsultas.save(tipoConsulta);
        }
    }
    

    @Override
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta) throws ExceptionTiposConsultasEscrita {
                
        if(tiposConsulta == null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getCodigoTipoConsulta() <= 0) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getNomeTipoConsulta()== null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getValorTipoConsulta() <0) {
           throw new ExceptionTiposConsultasEscrita();
        }
        if(this.repositorioTiposConsultas.exists(tiposConsulta.getCodigoTipoConsulta())==false) {
            throw new ExceptionTiposConsultasEscrita();
        }
        else {
            TiposConsultas novoTiposConsultas = this.repositorioTiposConsultas.findByCodigoTipoConsulta(tiposConsulta.getCodigoTipoConsulta());
              
               novoTiposConsultas.setNomeTipoConsulta(tiposConsulta.getNomeTipoConsulta());
               novoTiposConsultas.setValorTipoConsulta(tiposConsulta.getValorTipoConsulta());
               
                  this.repositorioTiposConsultas.save(novoTiposConsultas);
        }      
    }

    @Override
    public void deletarTipoConsulta(int codigoTipoConsulta) throws ExceptionTiposConsultasEscrita {
       
        if(codigoTipoConsulta <= 0) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(this.repositorioTiposConsultas.exists(codigoTipoConsulta)==false){
            throw new ExceptionTiposConsultasEscrita();
        }
        else {
            this.repositorioTiposConsultas.delete(codigoTipoConsulta);
        }
    }

    @Override
    public List<TiposConsultas> listarTiposConsulta() throws ExceptionTiposConsultasLeitura {
      
        return this.repositorioTiposConsultas.findAll();
    }

    @Override
    public List<TiposConsultas> filtrarTipoConsultaNome(String nome) throws ExceptionTiposConsultasLeitura {
       
        if(nome == null) {
            throw new ExceptionTiposConsultasLeitura();
        }
        else {
            return this.repositorioTiposConsultas.findByNomeTipoConsultaStartingWith(nome);
        }
    }

    @Override
    public TiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta) throws ExceptionTiposConsultasLeitura {
      
        if(codigoTipoConsulta <= 0) {
            throw new ExceptionTiposConsultasLeitura();
        }
        else {
           return this.repositorioTiposConsultas.findByCodigoTipoConsulta(codigoTipoConsulta);
        }
    }

    
    
    public InterfaceRepositorioTiposConsultas getRepositorioTiposConsultas() {
        return repositorioTiposConsultas;
    }

    public void setRepositorioTiposConsultas(InterfaceRepositorioTiposConsultas repositorioTiposConsultas) {
        this.repositorioTiposConsultas = repositorioTiposConsultas;
    }
    
}
