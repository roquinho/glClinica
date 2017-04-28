
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioProntuarios extends Serializable {
    
  public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento)throws ExceptionMedicamentosEscrita;

  public void atualizarProntuario(Prontuarios prontuarios)throws ExceptionMedicamentosEscrita;
  
  public void deletarProntuario(int codigoProntuario)throws ExceptionMedicamentosEscrita;
  
  public Prontuarios filtrarProntuarioCodigo(int codigoProntuario)throws ExceptionMedicamentosLeitura;
}


