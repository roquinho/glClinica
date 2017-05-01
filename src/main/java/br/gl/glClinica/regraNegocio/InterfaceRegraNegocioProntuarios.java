
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosLeitura;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioProntuarios extends Serializable {
    
  public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento)throws ExceptionProntuariosEscrita;

  public void atualizarProntuario(Prontuarios prontuarios)throws ExceptionProntuariosEscrita;
  
  public void deletarProntuario(int codigoProntuario)throws ExceptionProntuariosEscrita;
  
  public Prontuarios filtrarProntuarioCodigo(int codigoProntuario)throws ExceptionProntuariosLeitura;
}


