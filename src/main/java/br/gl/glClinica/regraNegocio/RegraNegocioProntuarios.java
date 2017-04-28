
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioProntuarios;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
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
    public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarProntuario(Prontuarios prontuarios) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarProntuario(int codigoProntuario) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prontuarios filtrarProntuarioCodigo(int codigoProntuario) throws ExceptionMedicamentosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
