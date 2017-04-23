
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Convenios;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioConvenios extends CrudRepository<Convenios, Integer> {
    
    public Convenios findByCodigoConvenio(int codigoConvenio);
    
    public List<Convenios> findByNomeConvenioStartingWith(String nomeConvenio);
    
}
