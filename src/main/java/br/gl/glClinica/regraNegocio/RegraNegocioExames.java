
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioExames implements InterfaceRegraNegocioExames {

    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    
    @Override
    public void cadastrarExame(Exames exame) throws ExceptionExamesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarExame(Exames exame) throws ExceptionExamesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarExame(int codigoExame) throws ExceptionExamesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exames> listarExame() throws ExceptionExamesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exames> filtrarExameNome(String nomeExame) throws ExceptionExamesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Exames filtrarExameCodigo(int codigoExame) throws ExceptionExamesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }
    
}
