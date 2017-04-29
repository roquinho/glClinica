
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioExames implements InterfaceRegraNegocioExames {

    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    
    
    
    @Override
    public void cadastrarExame(Exames exame) throws ExceptionExamesEscrita {
       
        if(exame == null) {
            throw new ExceptionExamesEscrita();
        }
        if(exame.getNomeExame()==null) {
            throw new ExceptionExamesEscrita();
        }
        else {
            this.repositorioExames.save(exame);
        }
    }
    

    @Override
    public void atualizarExame(Exames exame) throws ExceptionExamesEscrita {
        
        if(exame == null) {
            throw new ExceptionExamesEscrita();
        }
        if(exame.getCodigoExame() == 0) {
            throw new ExceptionExamesEscrita();
        }
        if(exame.getNomeExame()==null) {
            throw new ExceptionExamesEscrita();
        }
        if(this.repositorioExames.exists(exame.getCodigoExame())==false) {
            throw new ExceptionExamesEscrita();
        }
        else {
            Exames novoExame = this.repositorioExames.findByCodigoExame(exame.getCodigoExame());
              
                novoExame.setNomeExame(exame.getNomeExame());
                novoExame.setObservacoesExame(exame.getObservacoesExame());
                
                    this.repositorioExames.save(novoExame);
        }
    }

    @Override
    public void deletarExame(int codigoExame) throws ExceptionExamesEscrita {
       
        if(codigoExame == 0) {
            throw new ExceptionExamesEscrita();
        }
        if(this.repositorioExames.exists(codigoExame)==false) {
            throw new ExceptionExamesEscrita();
        }
        else {
            this.repositorioExames.delete(codigoExame);
        }
    }

    @Override
    public List<Exames> listarExame() throws ExceptionExamesLeitura {
       
        return this.repositorioExames.findAll();
    }

    @Override
    public List<Exames> filtrarExameNome(String nomeExame) throws ExceptionExamesLeitura {
        if(nomeExame == null) {
            throw new ExceptionExamesLeitura();
        }
        else {
            return this.repositorioExames.findByNomeExameStartingWith(nomeExame);
        }
    }

    @Override
    public Exames filtrarExameCodigo(int codigoExame) throws ExceptionExamesLeitura {
        
        if(codigoExame == 0) {
            throw new ExceptionExamesLeitura();
        }
        else {
            return this.repositorioExames.findByCodigoExame(codigoExame);
        }
    }

    
    
    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }
    
}
