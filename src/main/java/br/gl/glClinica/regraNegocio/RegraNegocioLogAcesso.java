
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.LogAcesso;
import br.gl.glClinica.persistencia.InterfaceRepositorioLogAcesso;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoLeitura;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioLogAcesso implements InterfaceRegraNegocioLogAcesso {

    @Autowired
    private InterfaceRepositorioLogAcesso repositorioLogAcesso;
    
    @Override
    public void gerarLogAcesso(LogAcesso logAcesso) throws ExceptionLogAcessoEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogAcesso> listarLogsAcesso() throws ExceptionLogAcessoLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(Long codigoUsuario) throws ExceptionLogAcessoLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogAcesso filtrarLogAcessoDataAndHoraAcesso(Date diaAcesso, Date horaAcesso) throws ExceptionLogAcessoLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoData(Date diaAcesso) throws ExceptionLogAcessoLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogAcesso filtrarLogAcessoCodigo(int codigoLogAcesso) throws ExceptionLogAcessoLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioLogAcesso getRepositorioLogAcesso() {
        return repositorioLogAcesso;
    }

    public void setRepositorioLogAcesso(InterfaceRepositorioLogAcesso repositorioLogAcesso) {
        this.repositorioLogAcesso = repositorioLogAcesso;
    }
    
}
