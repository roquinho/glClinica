
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Clinica;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioClinica extends CrudRepository<Clinica, String> {
    
    public Clinica findByCnpj(String cnpj);
    
    public List<Clinica> findByNomeStartingWith(String nome);
    
    @Override
    public List<Clinica> findAll();
    
}
