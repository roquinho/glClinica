
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.entidades.Pacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioConvenios;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesLeitura;
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
public class RegraNegocioPacientes implements InterfaceRegraNegocioPacientes {

    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
    @Autowired
    private InterfaceRepositorioConvenios repositorioConvenios;
    
    @Autowired
    private InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso;
    
    
    
    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionPacientesEscrita {
        
        if(paciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getCpf() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getCpf()<= 0) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getDataNascimento() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getLoginNome() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getNome() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getSenha() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getSexo() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(this.repositorioPacientes.exists(paciente.getCpf())== true) {
            throw new ExceptionPacientesEscrita();
        }
        else {
            this.repositorioPacientes.save(paciente);
        }
    }

    @Override
    public void atualizarPacientes(Pacientes paciente) throws ExceptionPacientesEscrita {
       
        if(paciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getCpf() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getCpf()<= 0) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getDataNascimento() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getLoginNome() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getNome() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getSenha() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(paciente.getSexo() == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(this.repositorioPacientes.exists(paciente.getCpf())== false) {
            throw new ExceptionPacientesEscrita();
        }
        else {
            
            Pacientes novoPaciente = this.repositorioPacientes.findByCpf(paciente.getCpf());
            
              novoPaciente.setDataNascimento(paciente.getDataNascimento());
              novoPaciente.setEmail(paciente.getEmail());
              novoPaciente.setEndereco(paciente.getEndereco());
              novoPaciente.setLoginNome(paciente.getLoginNome());
              novoPaciente.setNome(paciente.getNome());
              novoPaciente.setNomeMae(paciente.getNomeMae());
              novoPaciente.setNomePai(paciente.getNomePai());
              novoPaciente.setNumeroCarteira(paciente.getNumeroCarteira());
              novoPaciente.setRg(paciente.getRg());
              novoPaciente.setSenha(paciente.getSenha());
              novoPaciente.setSexo(paciente.getSexo());
              novoPaciente.setTelefoneCelular(paciente.getTelefoneCelular());
              novoPaciente.setTelefoneFixo(paciente.getTelefoneFixo());
              novoPaciente.setQuantidadeAcessos(paciente.getQuantidadeAcessos());
              
                  this.repositorioPacientes.save(novoPaciente);
        }
        
    }

    @Override
    public void deletarPaciente(Long cpf) throws ExceptionPacientesEscrita {
        
        if(cpf == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(cpf<=0) {
            throw new ExceptionPacientesEscrita();
        }
        if(this.repositorioPacientes.exists(cpf) == false) {
            throw new ExceptionPacientesEscrita();
        }
        else {
            this.repositorioPacientes.delete(cpf);
        }
    }

    @Override
    public List<Pacientes> listarPacientes() throws ExceptionPacientesLeitura {
        
        return this.repositorioPacientes.findAll();
    }

    @Override
    public List<Pacientes> filtrarPacientesNome(String nome) throws ExceptionPacientesLeitura {
        
       if(nome == null) {
           throw new ExceptionPacientesLeitura();
       } 
       else {
           return this.repositorioPacientes.findByNomeStartingWith(nome);
       }
    }

    @Override
    public Pacientes filtrarPacientesLoginNomeAndSenha(String loginNome, String senha) throws ExceptionPacientesLeitura {
         
        Pacientes paciente;
        
         if(loginNome == null) {
             throw new ExceptionPacientesLeitura();
         }
         if(senha == null) {
             throw new ExceptionPacientesLeitura();
         }
         else {
            
             paciente = this.repositorioPacientes.findByLoginNomeAndSenha(loginNome, senha);
             
             if(paciente!=null) { 
                 
              paciente.setQuantidadeAcessos(paciente.getQuantidadeAcessos()+1);
              
                try {
                    this.atualizarPacientes(paciente);
                } catch (ExceptionPacientesEscrita ex) {
                    Logger.getLogger(RegraNegocioPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /* LogAcesso logAcesso = new LogAcesso(new Date(), new Date(), paciente.getCpf());
                 
                try {
                    this.regraNegocioLogAcesso.gerarLogAcesso(logAcesso);
                } catch (ExceptionLogAcessoEscrita ex) {
                    Logger.getLogger(RegraNegocioPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }*/
             }
         }
         return paciente;
    }

    @Override
    public Pacientes filtrarPacientesCpf(Long cpf) throws ExceptionPacientesLeitura {
        
        if(cpf == null) {
            throw new ExceptionPacientesLeitura();
        }
        if(cpf <= 0 ) {
            throw new ExceptionPacientesLeitura();
        }
        else {
            return this.repositorioPacientes.findByCpf(cpf);
        }
    }

    @Override
    public void receitarMedicamentoPaciente(Long cpfPaciente, int codigoMedicamentos) throws ExceptionPacientesEscrita {
       
        Pacientes paciente;
        Medicamentos medicamento;
        
        if(cpfPaciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(cpfPaciente<= 0) {
            throw new ExceptionPacientesEscrita();
        }
        if(codigoMedicamentos <=0) {
            throw new ExceptionPacientesEscrita();
        }
        else {
           paciente = this.repositorioPacientes.findByCpf(cpfPaciente);
           medicamento = this.repositorioMedicamentos.findByCodigoMedicamento(codigoMedicamentos);
        }
        if(paciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(medicamento == null) {
            throw new ExceptionPacientesEscrita();
        }                                
        else {
              paciente.getMedicamentos().add(medicamento);
              this.repositorioPacientes.save(paciente);
        }
    }

    @Override
    public void marcarExamePaciente(Long cpfPaciente, int codigoExame) throws ExceptionPacientesEscrita {
        
        Pacientes paciente;
        Exames exame;
        
        if(cpfPaciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(cpfPaciente<= 0) {
            throw new ExceptionPacientesEscrita();
        }
        if(codigoExame<= 0 ) {
            throw new ExceptionPacientesEscrita();
        }
        else {
           paciente = this.repositorioPacientes.findByCpf(cpfPaciente);
           exame = this.repositorioExames.findByCodigoExame(codigoExame);
        }
        if(paciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(exame == null) {
            throw new ExceptionPacientesEscrita();
        }
        else {
           paciente.getExames().add(exame);
           this.repositorioPacientes.save(paciente);
        } 
    }

    @Override
    public void InserirConvenioPaciente(Long cpfPaciente, int codigoConvenio) throws ExceptionPacientesEscrita {
       
        Pacientes paciente;
        Convenios convenio;
        
        if(cpfPaciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(cpfPaciente <= 0 ) {
            throw new ExceptionPacientesEscrita();
        }
        if(codigoConvenio<= 0) {
            throw new ExceptionPacientesEscrita();
        }
        else {
          paciente = this.repositorioPacientes.findByCpf(cpfPaciente);
          convenio = this.repositorioConvenios.findByCodigoConvenio(codigoConvenio);
        }
        if(paciente == null) {
            throw new ExceptionPacientesEscrita();
        }
        if(convenio == null) {
            throw new ExceptionPacientesEscrita();
        }
        else {
           paciente.getConvenios().add(convenio);            
           this.repositorioPacientes.save(paciente);
        }
    }

    
    
    public InterfaceRepositorioPacientes getRepositorioPacientes() {
        return repositorioPacientes;
    }

    public void setRepositorioPacientes(InterfaceRepositorioPacientes repositorioPacientes) {
        this.repositorioPacientes = repositorioPacientes;
    }

    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }

    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }

    public InterfaceRepositorioConvenios getRepositorioConvenios() {
        return repositorioConvenios;
    }

    public void setRepositorioConvenios(InterfaceRepositorioConvenios repositorioConvenios) {
        this.repositorioConvenios = repositorioConvenios;
    }

    public InterfaceRegraNegocioLogAcesso getRegraNegocioLogAcesso() {
        return regraNegocioLogAcesso;
    }

    public void setRegraNegocioLogAcesso(InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso) {
        this.regraNegocioLogAcesso = regraNegocioLogAcesso;
    }
    
}
