
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Laudos;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosLeitura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioLaudos extends Serializable {
 
   public void gerarLaudo(Laudos laudo, Long cpfMedico, Long cpfPaciente)throws ExceptionLaudosEscrita;
   
   public void atualizarLaudo(Laudos laudo)throws ExceptionLaudosEscrita;
   
   public void deletarLaudo(int codigoLaudo)throws ExceptionLaudosEscrita;
   
   public List<Laudos> filtrarLaudoData(Date dataLaudo)throws ExceptionLaudosLeitura;
   
   public Laudos filtrarLaudoCodigo(int codigoLaudo)throws ExceptionLaudosLeitura;

}
