
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Pacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioConvenios;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesLeitura;
import java.util.List;
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
    
    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarPacientes(Pacientes paciente) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarPaciente(Long cpf) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pacientes> listarPacientes() throws ExceptionPacientesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pacientes> filtrarPacientesNome(String nome) throws ExceptionPacientesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pacientes> filtrarPacientesLoginNomeSenha(String loginNome, String senha) throws ExceptionPacientesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pacientes filtrarPacientesCpf(Long cpf) throws ExceptionPacientesLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void receitarMedicamentoPaciente(Long cpfPaciente, int codigoMedicamento) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void marcarExamePaciente(Long cpfPaciente, int codigoExame) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InserirConvenioPaciente(Long cpfPaciente, int codigoConvenio) throws ExceptionPacientesEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
