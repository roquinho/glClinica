
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.listarEntidades.ListarTiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioTiposConsultas extends Serializable {
    
    public void cadastrarTipoConsulta(TiposConsultas tipoConsulta)throws ExceptionTiposConsultasEscrita;
    
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta)throws ExceptionTiposConsultasEscrita;
    
    public void deletarTipoConsulta(int codigoTipoConsulta)throws ExceptionTiposConsultasEscrita;
    
    public List<ListarTiposConsultas> listarTiposConsulta()throws ExceptionTiposConsultasLeitura;
    
    public List<ListarTiposConsultas> filtrarTipoConsultaNome(String nome)throws ExceptionTiposConsultasLeitura;
    
    public ListarTiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta)throws ExceptionTiposConsultasLeitura;

}
