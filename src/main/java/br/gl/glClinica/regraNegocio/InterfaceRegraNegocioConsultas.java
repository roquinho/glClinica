
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Consultas;
import br.gl.glClinica.listarEntidades.ListarConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasLeitura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioConsultas extends Serializable {
    
  public void marcarConsulta(Consultas consulta, Long cpfMedico, Long cpfPaciente, int tipoConsulta)throws ExceptionConsultasEscrita;
  
  public void atualizarConsulta(Consultas consulta)throws ExceptionConsultasEscrita;
  
  public void desmarcarConsulta(int codigoConsulta)throws ExceptionConsultasEscrita;;
  
  public List<ListarConsultas> listarConsultas()throws ExceptionConsultasLeitura;
  
  public List<ListarConsultas> filtrarConsultaDataConsulta(Date dataConsulta)throws ExceptionConsultasLeitura;
  
  public ListarConsultas filtrarConsultaCodigo(int codigoConsulta)throws ExceptionConsultasLeitura;
  
  public ListarConsultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta)throws ExceptionConsultasLeitura;
  
  
}
