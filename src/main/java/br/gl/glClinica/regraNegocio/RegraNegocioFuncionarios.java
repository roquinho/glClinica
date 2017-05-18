
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.persistencia.InterfaceRepositorioCargos;
import br.gl.glClinica.persistencia.InterfaceRepositorioFuncionarios;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
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
public class RegraNegocioFuncionarios implements InterfaceRegraNegocioFuncionarios {

    @Autowired
    private InterfaceRepositorioFuncionarios repositorioFuncionarios;
    @Autowired
    private InterfaceRepositorioCargos repositorioCargos;
    
    @Autowired
    private InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso;
    
    
    
    @Override
    public void cadastrarFuncionario(Funcionarios funcionario, int codigoCargo) throws ExceptionFuncionariosEscrita {
      
        if(funcionario == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(codigoCargo <= 0) {
            throw new ExceptionFuncionariosEscrita();
        }
        else {
            funcionario.setCargo(this.repositorioCargos.findByCodigoCargo(codigoCargo));
        }
        if(funcionario.getCargo() == null) {
            throw new ExceptionFuncionariosEscrita();
        }        
        if(funcionario.getCpf() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getCpf() <= 0) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getEndereco() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getNome() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getNomeUsuario() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getSenha() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getRg() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(this.repositorioFuncionarios.exists(funcionario.getCpf())==true) {
            throw new ExceptionFuncionariosEscrita();
        }
        else {
            this.repositorioFuncionarios.save(funcionario);             
        }
    }

    @Override
    public void atualizarFuncionario(Funcionarios funcionario) throws ExceptionFuncionariosEscrita {
        
        
        if(funcionario == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getCpf() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getCpf() <= 0) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getEndereco() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getNome() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getNomeUsuario() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getSenha() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(funcionario.getRg() == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(this.repositorioFuncionarios.exists(funcionario.getCpf())==false) {
            throw new ExceptionFuncionariosEscrita();
        }        
        else {
            
            Funcionarios novoFuncionario = this.repositorioFuncionarios.findByCpf(funcionario.getCpf());
            
               novoFuncionario.setContadorAcesso(funcionario.getContadorAcesso());
               novoFuncionario.setEndereco(funcionario.getEndereco());
               novoFuncionario.setNome(funcionario.getNome());
               novoFuncionario.setNomeUsuario(funcionario.getNomeUsuario());
               novoFuncionario.setRg(funcionario.getRg());
               novoFuncionario.setSenha(funcionario.getSenha());
               novoFuncionario.setTelefoneCelular(funcionario.getTelefoneCelular());
               novoFuncionario.setTelefoneFixo(funcionario.getTelefoneFixo());
               
                    this.repositorioFuncionarios.save(novoFuncionario);
        }
        
    }

    @Override
    public void deletarFuncionario(Long cpf) throws ExceptionFuncionariosEscrita {
        
        if(cpf == null) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(cpf <= 0) {
            throw new ExceptionFuncionariosEscrita();
        }
        if(this.repositorioFuncionarios.exists(cpf)==false) {
            throw new ExceptionFuncionariosEscrita();
        }
        else {
           this.repositorioFuncionarios.delete(cpf);
        }
    }

    @Override
    public List<Funcionarios> listarFuncionarios() throws ExceptionFuncionariosLeitura {
         
        return this.repositorioFuncionarios.findAll();
    }

    @Override
    public List<Funcionarios> filtrarFuncionariosNome(String nome) throws ExceptionFuncionariosLeitura {
        
        if(nome == null) {
            throw new ExceptionFuncionariosLeitura();
        }
        else {
           return this.repositorioFuncionarios.findByNomeStartingWith(nome);
        }
    }

    @Override
    public Funcionarios filtrarFuncionarioCpf(Long cpf) throws ExceptionFuncionariosLeitura {
        
        if(cpf == null) {
            throw new ExceptionFuncionariosLeitura();
        }
        if(cpf <= 0) {
            throw new ExceptionFuncionariosLeitura();
        }
        else {
            return this.repositorioFuncionarios.findByCpf(cpf);
        }
        
    }

    @Override
    public Funcionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha) throws ExceptionFuncionariosLeitura {
       
        Funcionarios funcionario;
        
        if(nomeUsuario == null) {
            throw new ExceptionFuncionariosLeitura();
        }
        if(senha == null) {
            throw new ExceptionFuncionariosLeitura();
        }
        else {
           funcionario = this.repositorioFuncionarios.findByNomeUsuarioAndSenha(nomeUsuario, senha);
             if(funcionario != null) {
                 
               funcionario.setContadorAcesso(funcionario.getContadorAcesso()+1);
               
                 try {                   
                     this.atualizarFuncionario(funcionario);
               } catch (ExceptionFuncionariosEscrita ex) {
                   Logger.getLogger(RegraNegocioFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
               }
               
            /*LogAcesso logAcesso = new LogAcesso(new Date(), new Date(), funcionario.getCpf());
            
               try {
                   this.regraNegocioLogAcesso.gerarLogAcesso(logAcesso);
               } catch (ExceptionLogAcessoEscrita ex) {
                   Logger.getLogger(RegraNegocioFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
               }*/
                    
             }
              
        }
        return funcionario;        
    }

    public InterfaceRepositorioFuncionarios getRepositorioFuncionarios() {
        return repositorioFuncionarios;
    }

    public void setRepositorioFuncionarios(InterfaceRepositorioFuncionarios repositorioFuncionarios) {
        this.repositorioFuncionarios = repositorioFuncionarios;
    }

    public InterfaceRepositorioCargos getRepositorioCargos() {
        return repositorioCargos;
    }

    public void setRepositorioCargos(InterfaceRepositorioCargos repositorioCargos) {
        this.repositorioCargos = repositorioCargos;
    }

    public InterfaceRegraNegocioLogAcesso getRegraNegocioLogAcesso() {
        return regraNegocioLogAcesso;
    }

    public void setRegraNegocioLogAcesso(InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso) {
        this.regraNegocioLogAcesso = regraNegocioLogAcesso;
    }
    
}
