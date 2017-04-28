
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Medicamentos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioMedicamentos extends CrudRepository<Medicamentos, Integer> {

    public Medicamentos findByCodigoMedicamento(int codigoMedicamento);
     
    public List<Medicamentos> findByNomeMedicamentoStartingWith(String nomeMedicamento);
    
    public List<Medicamentos> findByNomeLaboratorioStartingWith(String nomeLaboratorio);
      
    @Override
    public List<Medicamentos> findAll();
      
      
}
