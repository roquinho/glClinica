
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.listarEntidades.ListarConvenios;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *S
 * @author manoel
 */
public interface InterfaceRegraNegocioConvenios extends Serializable {
    
    public void cadastrarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void atualizarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void deletarConvenio(int codigoConvenio)throws ExceptionConveniosEscrita;
    
    public List<ListarConvenios> listarConvenios()throws ExceptionConveniosLeitura;
    
    public List<ListarConvenios> filtrarConvenioNome(String nomeConvenio)throws ExceptionConveniosLeitura;
    
    public ListarConvenios filtrarConvenioCodigo(int codigoConvenio)throws ExceptionConveniosLeitura;

}
