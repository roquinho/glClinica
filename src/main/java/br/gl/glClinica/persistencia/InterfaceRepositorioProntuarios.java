
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Prontuarios;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioProntuarios extends CrudRepository<Prontuarios, Integer> {
    
    public Prontuarios findByCodigoProntuario(int codigoProntuario);
    
    
    
}
