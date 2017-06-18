
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.listarEntidades.ListarExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import java.util.ArrayList;
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
        if(exame.getCodigoExame() <= 0) {
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
       
        if(codigoExame <= 0) {
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
    public List<ListarExames> listarExame() throws ExceptionExamesLeitura {
       List<ListarExames> listaListarExames = null;
         List<Exames> listaExamesBD = this.repositorioExames.findAll();
           if(listaExamesBD!=null) {
              listaListarExames = new ArrayList<>();
                for(int i=0; i<listaExamesBD.size(); i++) {
                 ListarExames listaExames = new ListarExames(listaExamesBD.get(i));
                  listaListarExames.add(listaExames);
               }
           }
           return listaListarExames;
    }

    @Override
    public List<ListarExames> filtrarExameNome(String nomeExame) throws ExceptionExamesLeitura {
      List<ListarExames> listaListarExames = null;
      
        if(nomeExame == null) {
            throw new ExceptionExamesLeitura();
        }
        else {
            List<Exames> listaExamesBD = this.repositorioExames.findByNomeExameStartingWith(nomeExame);
        if(listaExamesBD!=null) {
              listaListarExames = new ArrayList<>();
                for(int i=0; i<listaExamesBD.size(); i++) {
                    ListarExames listaExames = new ListarExames(listaExamesBD.get(i));
                      listaListarExames.add(listaExames);
                }
        }                  
        }
        return listaListarExames;
    }

    @Override
    public ListarExames filtrarExameCodigo(int codigoExame) throws ExceptionExamesLeitura {
      ListarExames listaExames = null;     
        if(codigoExame <= 0) {
            throw new ExceptionExamesLeitura();
        }
        else {
            Exames exame = this.repositorioExames.findByCodigoExame(codigoExame);
        if(exame!=null) {
              listaExames = new ListarExames(exame);
        }    
        }
        return listaExames;
    }

    
    
    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }
    
}
