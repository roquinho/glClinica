
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Cargos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioCargos extends CrudRepository<Cargos,Integer> {
    
    public Cargos findByCodigoCargo(int codigoCargo);
    
    public List<Cargos> findByNomeCargoStartingWith(String nomeCargo);
}
