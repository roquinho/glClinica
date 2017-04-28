
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Cargos;
import br.gl.glClinica.regraNegocioException.ExceptionCargosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionCargosLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioCargos extends Serializable {
    
    public void cadastrarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void atualizarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void deletarCargo(int codigoCargo)throws ExceptionCargosEscrita;
    
    public List<Cargos> listarCargos()throws ExceptionCargosLeitura;
    
    public Cargos filtrarCargoCodigo(int codigoCargo)throws ExceptionCargosLeitura;
    
    public List<Cargos> filtrarCargoNome(String nomeCargo)throws ExceptionCargosLeitura;
    
    
}
