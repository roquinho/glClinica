
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.TiposConsultas;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioTiposConsultas extends CrudRepository<TiposConsultas, Integer>{
   
    public TiposConsultas findByCodigoTipoConsulta(int codigoTipoConsulta);
    
    public List<TiposConsultas> findByNomeTipoConsultaStartingWith(String nomeTipoConsulta);
}
