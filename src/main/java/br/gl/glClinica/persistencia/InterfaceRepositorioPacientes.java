
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Pacientes;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioPacientes extends CrudRepository<Pacientes, Long> {
    
    public Pacientes findByCpf(Long cpf);
    
    public List<Pacientes> findByNomeStartingWith(String nome);
    
    public Pacientes findByLoginNomeAndSenha(String loginNome,String senha);
    
    @Override
    public List<Pacientes> findAll();
    
   
}
