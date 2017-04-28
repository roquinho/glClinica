
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta) throws ExceptionTiposConsultasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarTipoConsulta(int codigoTipoConsulta) throws ExceptionTiposConsultasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiposConsultas> listarTiposConsulta() throws ExceptionTiposConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TiposConsultas> filtrarTipoConsultaNome(String nome) throws ExceptionTiposConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta) throws ExceptionTiposConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioTiposConsultas getRepositorioTiposConsultas() {
        return repositorioTiposConsultas;
    }

    public void setRepositorioTiposConsultas(InterfaceRepositorioTiposConsultas repositorioTiposConsultas) {
        this.repositorioTiposConsultas = repositorioTiposConsultas;
    }
    
}
