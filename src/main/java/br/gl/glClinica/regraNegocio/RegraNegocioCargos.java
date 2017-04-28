
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
        
    }

    @Override
    public void atualizarCargo(Cargos cargo) throws ExceptionCargosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarCargo(int codigoCargo) throws ExceptionCargosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cargos> listarCargos() throws ExceptionCargosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargos filtrarCargoCodigo(int codigoCargo) throws ExceptionCargosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cargos> filtrarCargoNome(String nomeCargo) throws ExceptionCargosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioCargos getRepositorioCargos() {
        return repositorioCargos;
    }

    public void setRepositorioCargos(InterfaceRepositorioCargos repositorioCargos) {
        this.repositorioCargos = repositorioCargos;
    }
    
}
