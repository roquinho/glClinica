
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Exames;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioExames extends CrudRepository<Exames, Integer>{
    
    public Exames findByCodigoExame(int codigoExame);
    
    public List<Exames> findByNomeExameStartingWith(String nomeExame);
    
}
