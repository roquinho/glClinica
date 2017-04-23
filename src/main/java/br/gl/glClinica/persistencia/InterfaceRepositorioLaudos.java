
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Laudos;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioLaudos extends CrudRepository<Laudos, Integer>{
    
    public Laudos findByCodigoLaudo(int codigoLaudo);
    
    public List<Laudos> findByDataLaudo(Date dataLaudo);
    
}
