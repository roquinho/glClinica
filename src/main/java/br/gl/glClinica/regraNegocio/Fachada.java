
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Cargos;
import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.entidades.Consultas;
import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.entidades.Laudos;
import br.gl.glClinica.entidades.LogAcesso;
import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.entidades.Pacientes;
import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.entidades.Receitas;
import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.listarEntidades.ListarCargos;
import br.gl.glClinica.listarEntidades.ListarFuncionarios;
import br.gl.glClinica.regraNegocioException.ExceptionCargosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionCargosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface Fachada extends Serializable {
    
    public void cadastrarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void atualizarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void deletarCargo(int codigoCargo)throws ExceptionCargosEscrita;
    
    public List<ListarCargos> listarCargos()throws ExceptionCargosLeitura;
    
    public ListarCargos filtrarCargoCodigo(int codigoCargo)throws ExceptionCargosLeitura;
    
    public List<ListarCargos> filtrarCargoNome(String nomeCargo)throws ExceptionCargosLeitura;
    
    
    
    public void cadastrarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void atualizarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void deletarClinica(String cnpj)throws ExceptionClinicaEscrita;
    
    public List<Clinica> listarClinicas()throws ExceptionClinicaLeitura;
    
    public List<Clinica> filtrarClinicaNome(String nome)throws ExceptionClinicaLeitura;
    
    public Clinica filtrarClinicaCnpj(String cnpj)throws ExceptionClinicaLeitura;
    
    
    
    public void marcarConsulta(Consultas consulta, Long cpfMedico, Long cpfPaciente, int tipoConsulta)throws ExceptionConsultasEscrita;
  
    public void atualizarConsulta(Consultas consulta)throws ExceptionConsultasEscrita;
  
    public void desmarcarConsulta(int codigoConsulta)throws ExceptionConsultasEscrita;;
  
    public List<Consultas> listarConsultas()throws ExceptionConsultasLeitura;
  
    public List<Consultas> filtrarConsultaDataConsulta(Date dataConsulta)throws ExceptionConsultasLeitura;
  
    public Consultas filtrarConsultaCodigo(int codigoConsulta)throws ExceptionConsultasLeitura;
  
    public Consultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta)throws ExceptionConsultasLeitura;
  
    
    
    
    public void cadastrarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void atualizarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void deletarConvenio(int codigoConvenio)throws ExceptionConveniosEscrita;
    
    public List<Convenios> listarConvenios()throws ExceptionConveniosLeitura;
    
    public List<Convenios> filtrarConvenioNome(String nomeConvenio)throws ExceptionConveniosLeitura;
    
    public Convenios filtrarConvenioCodigo(int codigoConvenio)throws ExceptionConveniosLeitura;

    
    
    public void gerarLaudo(Laudos laudo, Long cpfMedico, Long cpfPaciente)throws ExceptionLaudosEscrita;
   
    public void atualizarLaudo(Laudos laudo)throws ExceptionLaudosEscrita;
   
    public void deletarLaudo(int codigoLaudo)throws ExceptionLaudosEscrita;
   
    public List<Laudos> filtrarLaudoData(Date dataLaudo)throws ExceptionLaudosLeitura;
   
    public Laudos filtrarLaudoCodigo(int codigoLaudo)throws ExceptionLaudosLeitura;

    
    
    
    public void cadastrarFuncionario(Funcionarios fincionario, int codigoCargo)throws ExceptionFuncionariosEscrita;
  
    public void atualizarFuncionario(Funcionarios funcionario)throws ExceptionFuncionariosEscrita;
  
    public void deletarFuncionario(Long cpf)throws ExceptionFuncionariosEscrita;
  
    public List<ListarFuncionarios> listarFuncionarios()throws ExceptionFuncionariosLeitura;
  
    public List<ListarFuncionarios> filtrarFuncionariosNome(String nome)throws ExceptionFuncionariosLeitura;
  
    public ListarFuncionarios filtrarFuncionarioCpf(Long cpf)throws ExceptionFuncionariosLeitura;
  
    public ListarFuncionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha)throws ExceptionFuncionariosLeitura;
  
    
    
    
    public void gerarLogAcesso(LogAcesso logAcesso)throws ExceptionLogAcessoEscrita;
    
    public List<LogAcesso> listarLogsAcesso()throws ExceptionLogAcessoLeitura;
    
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(Long codigoUsuario)throws ExceptionLogAcessoLeitura;
    
    public LogAcesso filtrarLogAcessoDataAndHoraAcesso(Date diaAcesso, Date horaAcesso)throws ExceptionLogAcessoLeitura;
    
    public List<LogAcesso> filtrarLogAcessoData(Date diaAcesso)throws ExceptionLogAcessoLeitura;
    
    public LogAcesso filtrarLogAcessoCodigo(int codigoLogAcesso)throws ExceptionLogAcessoLeitura;

    
    
    
    public void cadastrarMedicamento(Medicamentos medicamento)throws ExceptionMedicamentosEscrita;
    
    public void atualizarMedcicamento(Medicamentos medicamento)throws ExceptionMedicamentosEscrita;
    
    public void deletarMedicamento(int codigoMedicamento)throws ExceptionMedicamentosEscrita;
    
    public List<Medicamentos> listarMedicamentos()throws ExceptionMedicamentosLeitura;
    
    public List<Medicamentos> filtrarMedicamentoNome(String nomeMedicamento)throws ExceptionMedicamentosLeitura;
    
    public List<Medicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio)throws ExceptionMedicamentosLeitura;
    
    public Medicamentos filtrarMedicamentoCodigo(int codigoMedicamento)throws ExceptionMedicamentosLeitura;

    
    
    public void cadastrarTipoConsulta(TiposConsultas tipoConsulta)throws ExceptionTiposConsultasEscrita;
    
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta)throws ExceptionTiposConsultasEscrita;
    
    public void deletarTipoConsulta(int codigoTipoConsulta)throws ExceptionTiposConsultasEscrita;
    
    public List<TiposConsultas> listarTiposConsulta()throws ExceptionTiposConsultasLeitura;
    
    public List<TiposConsultas> filtrarTipoConsultaNome(String nome)throws ExceptionTiposConsultasLeitura;
    
    public TiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta)throws ExceptionTiposConsultasLeitura;

    
        
    public void cadastrarExame(Exames exame)throws ExceptionExamesEscrita;
    
    public void atualizarExame(Exames exame)throws ExceptionExamesEscrita;
    
    public void deletarExame(int codigoExame)throws ExceptionExamesEscrita;
    
    public List<Exames> listarExame()throws ExceptionExamesLeitura;
    
    public List<Exames> filtrarExameNome(String nomeExame)throws ExceptionExamesLeitura;
    
    public Exames filtrarExameCodigo(int codigoExame)throws ExceptionExamesLeitura;

    
    
    
    public void cadastrarMedico(Medicos medico)throws ExceptionMedicosEscrita;
    
    public void atualizarMedico(Medicos medico)throws ExceptionMedicosEscrita;
    
    public void deletarMedico(Long cpf)throws ExceptionMedicosEscrita;
    
    public List<Medicos> listarMedicos()throws ExceptionMedicosLeitura;
    
    public List<Medicos> filtrarMedicoNome(String nome)throws ExceptionMedicosLeitura;
    
    public List<Medicos> filtrarMedicoEspecialidade(String especialidade)throws ExceptionMedicosLeitura;
    
    public Medicos filtrarMedicoCpf(Long cpf)throws ExceptionMedicosLeitura;
    
    public Medicos filtrarMedicoUsuarioSenha(String usuario, String senha)throws ExceptionMedicosLeitura;


    
    
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
      
    public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento)throws ExceptionProntuariosEscrita;

   
    
    public void atualizarProntuario(Prontuarios prontuarios)throws ExceptionProntuariosEscrita;
  
    public void deletarProntuario(int codigoProntuario)throws ExceptionProntuariosEscrita;
  
    public Prontuarios filtrarProntuarioCodigo(int codigoProntuario)throws ExceptionProntuariosLeitura;

    public void gerarReceita(Receitas receita, Long cpfMedico, Long cpfPaciente)throws ExceptionReceitasEscrita;
 
    
    
    public void atualizarReceita(Receitas receita)throws ExceptionReceitasEscrita;
 
    public void deletarReceita(int codigoReceita)throws ExceptionReceitasEscrita;
 
    public Receitas filtrarReceitaCodigo(int codigoReceita)throws ExceptionReceitasLeitura;
 
    public void inserirExameReceita(int codigoReceita, int codigoExame)throws ExceptionReceitasEscrita;
 
    public void inserirMedicamentoReceita(int codigoReceita, int codigoMedicamento)throws ExceptionReceitasEscrita;
 
    
}
