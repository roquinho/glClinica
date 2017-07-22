
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
       
        if(logAcesso == null) {
            throw new ExceptionLogAcessoEscrita();
        }
        if(logAcesso.getCodigoUsuario()<=0) {
            throw new ExceptionLogAcessoEscrita();
        }
        if(logAcesso.getCodigoUsuario() == null) {
            throw new ExceptionLogAcessoEscrita();
        }
        if(logAcesso.getDiaAcesso() == null) {
            throw new ExceptionLogAcessoEscrita();
        }
        if(logAcesso.getHoraAcesso() == null) {
            throw new ExceptionLogAcessoEscrita();
        }        
        else {            
            this.repositorioLogAcesso.save(logAcesso);
        }
    }

    @Override
    public List<LogAcesso> listarLogsAcesso() throws ExceptionLogAcessoLeitura {
        
        return this.repositorioLogAcesso.findAll();
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(Long codigoUsuario) throws ExceptionLogAcessoLeitura {
      
        if(codigoUsuario == null) {
            throw new ExceptionLogAcessoLeitura();
        }
        if(codigoUsuario<=0) {
            throw new ExceptionLogAcessoLeitura();
        }
        else {
            return this.repositorioLogAcesso.findByCodigoUsuario(codigoUsuario);
        }
    }

    @Override
    public LogAcesso filtrarLogAcessoDataAndHoraAcesso(Date diaAcesso, Date horaAcesso) throws ExceptionLogAcessoLeitura {
        
        if(diaAcesso == null) {
            throw new ExceptionLogAcessoLeitura();
        }
        if(horaAcesso == null) {
            throw new ExceptionLogAcessoLeitura();
        }
        else {
            return this.repositorioLogAcesso.findBydiaAcessoAndHoraAcesso(diaAcesso, horaAcesso);
        }
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoData(Date diaAcesso) throws ExceptionLogAcessoLeitura {
        
        if(diaAcesso == null) {
            throw new ExceptionLogAcessoLeitura();
        }
        else {
            return this.repositorioLogAcesso.findByDiaAcesso(diaAcesso);
        }
    }

    @Override
    public LogAcesso filtrarLogAcessoCodigo(int codigoLogAcesso) throws ExceptionLogAcessoLeitura {
        
        if(codigoLogAcesso<=0) {
            throw new ExceptionLogAcessoLeitura();
        }
        else {
            return this.repositorioLogAcesso.findByCodigoAcesso(codigoLogAcesso);
        }
    }

    public InterfaceRepositorioLogAcesso getRepositorioLogAcesso() {
        return repositorioLogAcesso;
    }

    public void setRepositorioLogAcesso(InterfaceRepositorioLogAcesso repositorioLogAcesso) {
        this.repositorioLogAcesso = repositorioLogAcesso;
    }
    
}
