
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Pacientes;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioPacientes extends Serializable {
    
     public void cadastrarPaciente(Pacientes paciente)throws ExceptionPacientesEscrita;
    
     public void atualizarPacientes(Pacientes paciente)throws ExceptionPacientesEscrita;
     
     public void deletarPaciente(Long cpf)throws ExceptionPacientesEscrita;
    
     public List<Pacientes> listarPacientes()throws ExceptionPacientesLeitura;
     
     public List<Pacientes> filtrarPacientesNome(String nome)throws ExceptionPacientesLeitura;
     
     public Pacientes filtrarPacientesLoginNomeAndSenha(String loginNome, String senha)throws ExceptionPacientesLeitura;
     
     public Pacientes filtrarPacientesCpf(Long cpf)throws ExceptionPacientesLeitura;
     
     public void receitarMedicamentoPaciente(Long cpfPaciente,int codigoMedcicamento)throws ExceptionPacientesEscrita;
     
     public void marcarExamePaciente(Long cpfPaciente,int codigoExame)throws ExceptionPacientesEscrita;
     
     public void InserirConvenioPaciente(Long cpfPaciente, int codigoConvenio)throws ExceptionPacientesEscrita;
     
     
}
