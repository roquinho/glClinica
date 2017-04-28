
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Medicos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioMedicos extends CrudRepository<Medicos, Long>{
    
   public Medicos findByCpf(Long cpf);
   
   public List<Medicos> findByNomeStartingWith(String nome);
   
   public Medicos findByNomeUsuarioAndSenhaAcesso(String nomeUsuario, String senhaAcesso);
   
   public List<Medicos> findByEspecialidadesStartingWith(String especialidades);
   
   @Override
   public List<Medicos> findAll();
    
}
