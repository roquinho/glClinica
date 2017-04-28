
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.LogAcesso;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoLeitura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioLogAcesso extends Serializable {
    
    public void gerarLogAcesso(LogAcesso logAcesso)throws ExceptionLogAcessoEscrita;
    
    public List<LogAcesso> listarLogsAcesso()throws ExceptionLogAcessoLeitura;
    
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(Long codigoUsuario)throws ExceptionLogAcessoLeitura;
    
    public LogAcesso filtrarLogAcessoDataAndHoraAcesso(Date diaAcesso, Date horaAcesso)throws ExceptionLogAcessoLeitura;
    
    public List<LogAcesso> filtrarLogAcessoData(Date diaAcesso)throws ExceptionLogAcessoLeitura;
    
    public LogAcesso filtrarLogAcessoCodigo(int codigoLogAcesso)throws ExceptionLogAcessoLeitura;
}
