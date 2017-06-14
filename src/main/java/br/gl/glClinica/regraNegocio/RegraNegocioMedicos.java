
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.listarEntidades.ListarMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioMedicos implements InterfaceRegraNegocioMedicos {    
    
    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    
    @Autowired
    private InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso;
    
    
    @Override
    public void cadastrarMedico(Medicos medico) throws ExceptionMedicosEscrita {
       
        if(medico == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCpf() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCpf()<=0) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCrm() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getEspecialidades() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getNome() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getNomeUsuario() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getSenhaAcesso() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(this.repositorioMedicos.exists(medico.getCpf()) == true) {
            throw new ExceptionMedicosEscrita();
        }
        else {
            this.repositorioMedicos.save(medico);
    }

    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionMedicosEscrita {
                       
        if(medico == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCpf() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCpf()<=0) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getCrm() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getEspecialidades() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getNome() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getNomeUsuario() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(medico.getSenhaAcesso() == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(this.repositorioMedicos.exists(medico.getCpf()) == false) {
            throw new ExceptionMedicosEscrita();
        }
        else {
            Medicos novoMedico = this.repositorioMedicos.findByCpf(medico.getCpf());
             
                novoMedico.setCrm(medico.getCrm());
                novoMedico.setEndereco(medico.getEndereco());
                novoMedico.setEspecialidades(medico.getEspecialidades());
                novoMedico.setNome(medico.getNome());
                novoMedico.setNomeUsuario(medico.getNomeUsuario());
                novoMedico.setRg(medico.getRg());
                novoMedico.setSenhaAcesso(medico.getSenhaAcesso());
                novoMedico.setTelefone(medico.getTelefone());
                novoMedico.setTelefoneResidencial(medico.getTelefoneResidencial());
                novoMedico.setContadorAcessos(medico.getContadorAcessos());
                
                  this.repositorioMedicos.save(novoMedico);
                        
        }        
    }

    @Override
    public void deletarMedico(Long cpf) throws ExceptionMedicosEscrita {
        
        if(cpf == null) {
            throw new ExceptionMedicosEscrita();
        }
        if(cpf <=0 ) {
            throw new ExceptionMedicosEscrita();
        }
        if(this.repositorioMedicos.exists(cpf)==false) {
            throw new ExceptionMedicosEscrita();
        }
        else {
            this.repositorioMedicos.delete(cpf);
        }
    }

    @Override
    public List<ListarMedicos> listarMedicos() throws ExceptionMedicosLeitura {
       List<ListarMedicos> listaListarMedicos = null; 
        List<Medicos> listaMedicosBD = this.repositorioMedicos.findAll();
         if(listaMedicosBD!=null) {
             listaListarMedicos = new ArrayList<>();
               for(int i=0; i<listaMedicosBD.size();i++) {
                  ListarMedicos listaMedicos = new ListarMedicos(listaMedicosBD.get(i));
                   listaListarMedicos.add(listaMedicos);
               }
         } 
         return listaListarMedicos;
    }

    @Override
    public List<ListarMedicos> filtrarMedicoNome(String nome) throws ExceptionMedicosLeitura {
     List<ListarMedicos> listaListarMedicos = null;   
        if(nome == null) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            List<Medicos> listaMedicosBD = this.repositorioMedicos.findByNomeStartingWith(nome);
        if(listaMedicosBD!=null) {
              listaListarMedicos = new ArrayList<>();
                for(int i=0; i<listaMedicosBD.size();i++) {
                    ListarMedicos listaMedicos = new ListarMedicos(listaMedicosBD.get(i));
                     listaListarMedicos.add(listaMedicos);
                }
        }      
        }
        return listaListarMedicos;
    }

    @Override
    public List<ListarMedicos> filtrarMedicoEspecialidade(String especialidade) throws ExceptionMedicosLeitura {
     List<ListarMedicos> listaListarMedicos = null;
     
        if(especialidade == null) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            List<Medicos> listaMedicosBD = this.repositorioMedicos.findByEspecialidadesStartingWith(especialidade);
              listaListarMedicos = new ArrayList<>();
                for(int i=0; i<listaMedicosBD.size();i++) {
                    ListarMedicos listaMedicos = new ListarMedicos(listaMedicosBD.get(i));
                     listaListarMedicos.add(listaMedicos); 
        }
        
    }
        return listaListarMedicos;
    }
    @Override
    public ListarMedicos filtrarMedicoCpf(Long cpf) throws ExceptionMedicosLeitura {
     ListarMedicos listaMedicos = null;
     
        if(cpf == null) {
            throw new ExceptionMedicosLeitura();
        }
        if(cpf <=0) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            Medicos medico = this.repositorioMedicos.findByCpf(cpf);
        if(medico!=null) {
               listaMedicos = new ListarMedicos(medico);
        }      
        }
        return listaMedicos;
    }

    @Override
    public ListarMedicos filtrarMedicoUsuarioSenha(String usuario, String senha) throws ExceptionMedicosLeitura {
      ListarMedicos listaMedicos = null; 
        Medicos medico;
        
        if(usuario == null) {
            throw new ExceptionMedicosLeitura();
        }
        if(senha == null) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            medico = this.repositorioMedicos.findByNomeUsuarioAndSenhaAcesso(usuario, senha);
              if(medico!= null) {
                  medico.setContadorAcessos(medico.getContadorAcessos()+1);
                try {
                    this.atualizarMedico(medico);
                } catch (ExceptionMedicosEscrita ex) {
                    Logger.getLogger(RegraNegocioMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*LogAcesso logAcesso = new LogAcesso(new Date(), new Date(), medico.getCpf());
                
                try {
                    this.regraNegocioLogAcesso.gerarLogAcesso(logAcesso);
                } catch (ExceptionLogAcessoEscrita ex) {
                    Logger.getLogger(RegraNegocioMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                listaMedicos = new ListarMedicos(medico);
              }
        }
        return listaMedicos;
    }

    public InterfaceRepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public void setRepositorioMedicos(InterfaceRepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }

    public InterfaceRegraNegocioLogAcesso getRegraNegocioLogAcesso() {
        return regraNegocioLogAcesso;
    }

    public void setRegraNegocioLogAcesso(InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso) {
        this.regraNegocioLogAcesso = regraNegocioLogAcesso;
    }
    
    
}
