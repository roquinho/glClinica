
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.LogAcesso;
import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
import java.util.Date;
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
    public List<Medicos> listarMedicos() throws ExceptionMedicosLeitura {
        
        return this.repositorioMedicos.findAll();
    }

    @Override
    public List<Medicos> filtrarMedicoNome(String nome) throws ExceptionMedicosLeitura {
        
        if(nome == null) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            return this.repositorioMedicos.findByNomeStartingWith(nome);
        }
    }

    @Override
    public List<Medicos> filtrarMedicoEspecialidade(String especialidade) throws ExceptionMedicosLeitura {
       
        if(especialidade == null) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            return this.repositorioMedicos.findByEspecialidadesStartingWith(especialidade);
        }
    }

    @Override
    public Medicos filtrarMedicoCpf(Long cpf) throws ExceptionMedicosLeitura {
        
        if(cpf == null) {
            throw new ExceptionMedicosLeitura();
        }
        if(cpf <=0) {
            throw new ExceptionMedicosLeitura();
        }
        else {
            return this.repositorioMedicos.findByCpf(cpf);
        }
    }

    @Override
    public Medicos filtrarMedicoUsuarioSenha(String usuario, String senha) throws ExceptionMedicosLeitura {
        
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
                
                LogAcesso logAcesso = new LogAcesso(new Date(), new Date(), medico.getCpf());
                
                try {
                    this.regraNegocioLogAcesso.gerarLogAcesso(logAcesso);
                } catch (ExceptionLogAcessoEscrita ex) {
                    Logger.getLogger(RegraNegocioMedicos.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
        }
        return medico;
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
