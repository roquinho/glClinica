
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioProntuarios;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosLeitura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioProntuarios implements InterfaceRegraNegocioProntuarios {

    @Autowired
    private InterfaceRepositorioProntuarios repositorioProntuarios;
    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
    
    
    
    @Override
    public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento) throws ExceptionProntuariosEscrita {
       
        if(prontuario == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(codigoExame <=0) {
            throw new ExceptionProntuariosEscrita();
        }
        if(cpfPaciente == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(cpfPaciente <= 0) {
            throw new ExceptionProntuariosEscrita();
        }
        if(codigoMedicamento <= 0 ) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            prontuario.setExame(this.repositorioExames.findByCodigoExame(codigoExame));
            prontuario.setMedicamento(this.repositorioMedicamentos.findByCodigoMedicamento(codigoMedicamento));
            prontuario.setPaciente(this.repositorioPacientes.findByCpf(cpfPaciente));
        }
        if(prontuario.getExame() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getMedicamento() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getPaciente() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getDataExame() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getDataInicioTratamento() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getPosologiaReceitada() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            this.repositorioProntuarios.save(prontuario);
        }
    }
    
    @Override
    public void atualizarProntuario(Prontuarios prontuarios) throws ExceptionProntuariosEscrita {
       
        if(prontuarios == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuarios.getCodigoProntuario()<=0) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuarios.getDataExame() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuarios.getDataInicioTratamento() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuarios.getPosologiaReceitada() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(this.repositorioProntuarios.exists(prontuarios.getCodigoProntuario())==false) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            Prontuarios novoProntuario = this.repositorioProntuarios.findByCodigoProntuario(prontuarios.getCodigoProntuario());
              
                novoProntuario.setDataExame(prontuarios.getDataExame());
                novoProntuario.setDataFimTratamento(prontuarios.getDataFimTratamento());
                novoProntuario.setDataInicioTratamento(prontuarios.getDataInicioTratamento());
                novoProntuario.setPosologiaReceitada(prontuarios.getPosologiaReceitada());
                novoProntuario.setResultadoExame(prontuarios.getResultadoExame());
                novoProntuario.setObservacoes(prontuarios.getObservacoes());
                
                   this.repositorioProntuarios.save(novoProntuario);
                
        }
    } 
    

    @Override
    public void deletarProntuario(int codigoProntuario) throws ExceptionProntuariosEscrita {
        
        if(codigoProntuario<=0) {
            throw new ExceptionProntuariosEscrita();
        }
        if(this.repositorioProntuarios.exists(codigoProntuario) == false) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            this.repositorioProntuarios.delete(codigoProntuario);
        }
    }
    @Override
    public Prontuarios filtrarProntuarioCodigo(int codigoProntuario) throws ExceptionProntuariosLeitura {
         
        if(codigoProntuario <= 0 ){
            throw new ExceptionProntuariosLeitura();
        }
        else {
            return this.repositorioProntuarios.findByCodigoProntuario(codigoProntuario);
        }
    }
    
    
    
    public InterfaceRepositorioProntuarios getRepositorioProntuarios() {
        return repositorioProntuarios;
    }

    public void setRepositorioProntuarios(InterfaceRepositorioProntuarios repositorioProntuarios) {
        this.repositorioProntuarios = repositorioProntuarios;
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

    

    
    
}
