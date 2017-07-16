
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.listarEntidades.ListarProntuarios;
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
    
    
    @Override
    public void gerarProntuario(Prontuarios prontuario, Long cpfPaciente) throws ExceptionProntuariosEscrita {
       
        if(prontuario == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(cpfPaciente == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(cpfPaciente <= 0) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            prontuario.setPaciente(this.repositorioPacientes.findByCpf(cpfPaciente));
        }
        if(prontuario.getPaciente() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(prontuario.getDataInicioTratamento() == null) {
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
        if(prontuarios.getDataInicioTratamento() == null) {
            throw new ExceptionProntuariosEscrita();
        }
        if(this.repositorioProntuarios.exists(prontuarios.getCodigoProntuario())==false) {
            throw new ExceptionProntuariosEscrita();
        }
        else {
            Prontuarios novoProntuario = this.repositorioProntuarios.findByCodigoProntuario(prontuarios.getCodigoProntuario());
                
                novoProntuario.setDataFimTratamento(prontuarios.getDataFimTratamento());
                novoProntuario.setDataInicioTratamento(prontuarios.getDataInicioTratamento());               
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
    public ListarProntuarios filtrarProntuarioCodigo(int codigoProntuario) throws ExceptionProntuariosLeitura {
      ListarProntuarios listaProntuarios = null;    
        if(codigoProntuario <= 0 ){
            throw new ExceptionProntuariosLeitura();
        }
        else {
            Prontuarios prontuario = this.repositorioProntuarios.findByCodigoProntuario(codigoProntuario);
        if(prontuario!=null) {
              listaProntuarios = new ListarProntuarios(prontuario);
        }    
        }
        return listaProntuarios;
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

    
}
