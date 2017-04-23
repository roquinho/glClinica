
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Funcionarios;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioFuncionarios extends CrudRepository<Funcionarios, Long>{
    
    public Funcionarios findByCpf(Long cpf);
    
    public List<Funcionarios> findByNomeStartingWith(String nome);
    
    public Funcionarios findByNomeUsuarioAndSenha(String nomeUsuario, String senha);
    
    
}
