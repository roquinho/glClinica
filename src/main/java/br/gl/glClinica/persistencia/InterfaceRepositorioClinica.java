
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Clinica;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioClinica extends CrudRepository<Clinica, Long> {
    
    public Clinica findByCnpj(Long cnpj);
    
    public List<Clinica> findByNomeStartingWith(String nome);
    
    @Override
    public List<Clinica> findAll();
    
}
