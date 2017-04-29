
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.TiposConsultas;
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
    
    public List<TiposConsultas> listarTiposConsulta()throws ExceptionTiposConsultasLeitura;
    
    public List<TiposConsultas> filtrarTipoConsultaNome(String nome)throws ExceptionTiposConsultasLeitura;
    
    public TiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta)throws ExceptionTiposConsultasLeitura;

}
