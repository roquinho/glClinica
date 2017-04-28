
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.Consultas;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioConsultas extends CrudRepository<Consultas, Integer> {
    
    public Consultas findByCodigoConsulta(int codigoConsulta);
    
    public List<Consultas> findByDataConsultaStartingWithOrderByDataConsulta(Date dataConsulta);
    
    public Consultas findByDataConsultaAndHoraConsultaStartingWithOrderByDataConsulta(Date dataConsulta, Date horaConsulta);
    
    @Override
    public List<Consultas> findAll();
    
}
