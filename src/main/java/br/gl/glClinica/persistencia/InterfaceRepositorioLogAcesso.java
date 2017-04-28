
package br.gl.glClinica.persistencia;

import br.gl.glClinica.entidades.LogAcesso;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioLogAcesso extends CrudRepository<LogAcesso, Integer>{ 
    
    public LogAcesso findByCodigoAcesso(int codigoAcesso);
    
    public List<LogAcesso> findByDiaAcesso(Date diaAcesso);
    
    public LogAcesso findBydiaAcessoAndHoraAcesso(Date diaAcesso, Date horaAcesso);
    
    public List<LogAcesso> findByCodigoUsuario(Long codigoUsuario);
    
    @Override
    public List<LogAcesso> findAll();
    
}
