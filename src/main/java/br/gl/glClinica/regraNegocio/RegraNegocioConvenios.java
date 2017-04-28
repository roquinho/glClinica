
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.persistencia.InterfaceRepositorioConvenios;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioConvenios implements InterfaceRegraNegocioConvenios {

    @Autowired
    private InterfaceRepositorioConvenios repositorioConvenios;
    
    @Override
    public void cadastrarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarConvenio(int codigoConvenio) throws ExceptionConveniosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Convenios> listarConvenios() throws ExceptionConveniosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Convenios> filtrarConvenioNome(String nomeConvenio) throws ExceptionConveniosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Convenios filtrarConvenioCodigo(int codigoConvenio) throws ExceptionConveniosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioConvenios getRepositorioConvenios() {
        return repositorioConvenios;
    }

    public void setRepositorioConvenios(InterfaceRepositorioConvenios repositorioConvenios) {
        this.repositorioConvenios = repositorioConvenios;
    }
    
}
