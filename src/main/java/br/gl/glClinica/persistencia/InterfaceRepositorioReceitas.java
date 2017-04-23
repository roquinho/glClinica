
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Receitas;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioReceitas extends CrudRepository<Receitas, Integer>{
    
    public Receitas findByCodigoReceita(int codigoReceita);
    
    
}
