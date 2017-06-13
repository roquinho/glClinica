
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
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class FachadaImplementa implements Fachada {
    
    @Autowired
    private InterfaceRegraNegocioCargos regraNegocioCargos;
    @Autowired
    private InterfaceRegraNegocioClinica regraNegocioClinica;
    @Autowired
    private InterfaceRegraNegocioFuncionarios regraNegocioFuncionarios;
    @Autowired
    private InterfaceRegraNegocioConvenios regraNegocioConvenios;
    @Autowired
    private InterfaceRegraNegocioExames regraNegocioExames;
    @Autowired
    private InterfaceRegraNegocioMedicamentos regraNegocioMedicamentos;
    @Autowired
    private InterfaceRegraNegocioTiposConsultas regraNegocioTiposConsultas;
    @Autowired
    private InterfaceRegraNegocioConsultas regraNegocioConsultas;
    @Autowired
    private InterfaceRegraNegocioLaudos regraNegocioLaudos;
    @Autowired
    private InterfaceRegraNegocioLogAcesso regraNegocioLogAcesso;
    @Autowired
    private InterfaceRegraNegocioMedicos regraNegocioMedicos;
    @Autowired
    private InterfaceRegraNegocioPacientes regraNegocioPacientes;
    @Autowired
    private InterfaceRegraNegocioProntuarios regraNegocioProntuarios;
    @Autowired
    private InterfaceRegraNegocioReceitas regraNegocioReceitas;
    
    
    
    @Override
    public void cadastrarCargo(Cargos cargo) throws ExceptionCargosEscrita {
      this.regraNegocioCargos.cadastrarCargo(cargo);
    }

    @Override
    public void atualizarCargo(Cargos cargo) throws ExceptionCargosEscrita {
        this.regraNegocioCargos.atualizarCargo(cargo);
    }

    @Override
    public void deletarCargo(int codigoCargo) throws ExceptionCargosEscrita {
        this.regraNegocioCargos.deletarCargo(codigoCargo);
    }

    @Override
    public List<ListarCargos> listarCargos() throws ExceptionCargosLeitura {
      return this.regraNegocioCargos.listarCargos();
    }

    @Override
    public ListarCargos filtrarCargoCodigo(int codigoCargo) throws ExceptionCargosLeitura {
      return this.regraNegocioCargos.filtrarCargoCodigo(codigoCargo);
    }

    @Override
    public List<ListarCargos> filtrarCargoNome(String nomeCargo) throws ExceptionCargosLeitura {
      return this.regraNegocioCargos.filtrarCargoNome(nomeCargo);
    }

    @Override
    public void cadastrarClinica(Clinica clinica) throws ExceptionClinicaEscrita {
       this.regraNegocioClinica.cadastrarClinica(clinica);
    }

    @Override
    public void atualizarClinica(Clinica clinica) throws ExceptionClinicaEscrita {
      this.regraNegocioClinica.atualizarClinica(clinica);
    }

    @Override
    public void deletarClinica(String cnpj) throws ExceptionClinicaEscrita {
        this.regraNegocioClinica.deletarClinica(cnpj);
    }

    @Override
    public List<Clinica> listarClinicas() throws ExceptionClinicaLeitura {
      return this.regraNegocioClinica.listarClinicas();
    }

    @Override
    public List<Clinica> filtrarClinicaNome(String nome) throws ExceptionClinicaLeitura {
      return this.regraNegocioClinica.filtrarClinicaNome(nome);
    }

    @Override
    public Clinica filtrarClinicaCnpj(String cnpj) throws ExceptionClinicaLeitura {
       return this.regraNegocioClinica.filtrarClinicaCnpj(cnpj);
    }

    @Override
    public void cadastrarFuncionario(Funcionarios fincionario, int codigoCargo) throws ExceptionFuncionariosEscrita {
      this.regraNegocioFuncionarios.cadastrarFuncionario(fincionario, codigoCargo);
    }

    @Override
    public void atualizarFuncionario(Funcionarios funcionario) throws ExceptionFuncionariosEscrita {
       this.regraNegocioFuncionarios.atualizarFuncionario(funcionario);
    }

    @Override
    public void deletarFuncionario(Long cpf) throws ExceptionFuncionariosEscrita {
        this.regraNegocioFuncionarios.deletarFuncionario(cpf);
    }

    @Override
    public List<ListarFuncionarios> listarFuncionarios() throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.listarFuncionarios();
    }

    @Override
    public List<ListarFuncionarios> filtrarFuncionariosNome(String nome) throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.filtrarFuncionariosNome(nome);
    }

    @Override
    public ListarFuncionarios filtrarFuncionarioCpf(Long cpf) throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.filtrarFuncionarioCpf(cpf);
    }

    @Override
    public ListarFuncionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha) throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.filtrarFuncionarioNomeUsuarioAndSenha(nomeUsuario, senha);
    }


    
    
    @Override
    public void cadastrarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
       this.regraNegocioConvenios.cadastrarConvenio(convenio);
    }

    @Override
    public void atualizarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
        this.regraNegocioConvenios.atualizarConvenio(convenio);
    }

    @Override
    public void deletarConvenio(int codigoConvenio) throws ExceptionConveniosEscrita {
        this.regraNegocioConvenios.deletarConvenio(codigoConvenio);
    }

    @Override
    public List<Convenios> listarConvenios() throws ExceptionConveniosLeitura {
        return this.regraNegocioConvenios.listarConvenios();
    }

    @Override
    public List<Convenios> filtrarConvenioNome(String nomeConvenio) throws ExceptionConveniosLeitura {
        return this.regraNegocioConvenios.filtrarConvenioNome(nomeConvenio);
    }

    @Override
    public Convenios filtrarConvenioCodigo(int codigoConvenio) throws ExceptionConveniosLeitura {
        return this.regraNegocioConvenios.filtrarConvenioCodigo(codigoConvenio);
    }

    
    
    @Override
    public void cadastrarMedicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
       this.regraNegocioMedicamentos.cadastrarMedicamento(medicamento);
    }

    @Override
    public void atualizarMedcicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
       this.regraNegocioMedicamentos.atualizarMedcicamento(medicamento);
    }

    @Override
    public void deletarMedicamento(int codigoMedicamento) throws ExceptionMedicamentosEscrita {
       this.regraNegocioMedicamentos.deletarMedicamento(codigoMedicamento);
    }

    @Override
    public List<Medicamentos> listarMedicamentos() throws ExceptionMedicamentosLeitura {
        return this.regraNegocioMedicamentos.listarMedicamentos();
    }

    @Override
    public List<Medicamentos> filtrarMedicamentoNome(String nomeMedicamento) throws ExceptionMedicamentosLeitura {
        return this.regraNegocioMedicamentos.filtrarMedicamentoNome(nomeMedicamento);
    }

    @Override
    public List<Medicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio) throws ExceptionMedicamentosLeitura {
        return this.regraNegocioMedicamentos.filtrarMedicamentosLaboratorio(nomeLaboratorio);
    }

    @Override
    public Medicamentos filtrarMedicamentoCodigo(int codigoMedicamento) throws ExceptionMedicamentosLeitura {
        return this.regraNegocioMedicamentos.filtrarMedicamentoCodigo(codigoMedicamento);
    }

    
    
    @Override
    public void cadastrarTipoConsulta(TiposConsultas tipoConsulta) throws ExceptionTiposConsultasEscrita {
       this.regraNegocioTiposConsultas.cadastrarTipoConsulta(tipoConsulta);
    }

    @Override
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta) throws ExceptionTiposConsultasEscrita {
        this.regraNegocioTiposConsultas.atualizarTipoConsulta(tiposConsulta);
    }

    @Override
    public void deletarTipoConsulta(int codigoTipoConsulta) throws ExceptionTiposConsultasEscrita {
        this.regraNegocioTiposConsultas.deletarTipoConsulta(codigoTipoConsulta);
    }

    @Override
    public List<TiposConsultas> listarTiposConsulta() throws ExceptionTiposConsultasLeitura {
        return this.regraNegocioTiposConsultas.listarTiposConsulta();
    }

    @Override
    public List<TiposConsultas> filtrarTipoConsultaNome(String nome) throws ExceptionTiposConsultasLeitura {
        return this.regraNegocioTiposConsultas.filtrarTipoConsultaNome(nome);
    }

    @Override
    public TiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta) throws ExceptionTiposConsultasLeitura {
        return this.regraNegocioTiposConsultas.filtrarTipoConsultaCodigo(codigoTipoConsulta);
    }

    @Override
    public void cadastrarExame(Exames exame) throws ExceptionExamesEscrita {
        this.regraNegocioExames.cadastrarExame(exame);
    }

    @Override
    public void atualizarExame(Exames exame) throws ExceptionExamesEscrita {
        this.regraNegocioExames.atualizarExame(exame);
    }

    @Override
    public void deletarExame(int codigoExame) throws ExceptionExamesEscrita {
        this.regraNegocioExames.deletarExame(codigoExame);
    }

    @Override
    public List<Exames> listarExame() throws ExceptionExamesLeitura {
       return this.regraNegocioExames.listarExame();
    }

    @Override
    public List<Exames> filtrarExameNome(String nomeExame) throws ExceptionExamesLeitura {
        return this.regraNegocioExames.filtrarExameNome(nomeExame);
    }

    @Override
    public Exames filtrarExameCodigo(int codigoExame) throws ExceptionExamesLeitura {
        return this.regraNegocioExames.filtrarExameCodigo(codigoExame);
    }

    @Override
    public void marcarConsulta(Consultas consulta, Long cpfMedico, Long cpfPaciente, int tipoConsulta) throws ExceptionConsultasEscrita {
        this.regraNegocioConsultas.marcarConsulta(consulta, cpfMedico, cpfPaciente, tipoConsulta);
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionConsultasEscrita {
        this.regraNegocioConsultas.atualizarConsulta(consulta);
    }

    @Override
    public void desmarcarConsulta(int codigoConsulta) throws ExceptionConsultasEscrita {
        this.regraNegocioConsultas.desmarcarConsulta(codigoConsulta);
    }

    @Override
    public List<Consultas> listarConsultas() throws ExceptionConsultasLeitura {
        return this.regraNegocioConsultas.listarConsultas();
    }

    @Override
    public List<Consultas> filtrarConsultaDataConsulta(Date dataConsulta) throws ExceptionConsultasLeitura {
        return this.regraNegocioConsultas.filtrarConsultaDataConsulta(dataConsulta);
    }

    @Override
    public Consultas filtrarConsultaCodigo(int codigoConsulta) throws ExceptionConsultasLeitura {
        return this.regraNegocioConsultas.filtrarConsultaCodigo(codigoConsulta);
    }

    @Override
    public Consultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta) throws ExceptionConsultasLeitura {
        return this.regraNegocioConsultas.filtrarConsultaDataAndHoraConsulta(dataConsulta, horaConsulta);
    }

    @Override
    public void gerarLaudo(Laudos laudo, Long cpfMedico, Long cpfPaciente) throws ExceptionLaudosEscrita {
      this.regraNegocioLaudos.gerarLaudo(laudo, cpfMedico, cpfPaciente);
    }

    @Override
    public void atualizarLaudo(Laudos laudo) throws ExceptionLaudosEscrita {
       this.regraNegocioLaudos.atualizarLaudo(laudo);
    }

    @Override
    public void deletarLaudo(int codigoLaudo) throws ExceptionLaudosEscrita {
        this.regraNegocioLaudos.deletarLaudo(codigoLaudo);
    }

    @Override
    public List<Laudos> filtrarLaudoData(Date dataLaudo) throws ExceptionLaudosLeitura {
        return this.regraNegocioLaudos.filtrarLaudoData(dataLaudo);
    }

    @Override
    public Laudos filtrarLaudoCodigo(int codigoLaudo) throws ExceptionLaudosLeitura {
        return this.regraNegocioLaudos.filtrarLaudoCodigo(codigoLaudo);
    }

    @Override
    public void gerarLogAcesso(LogAcesso logAcesso) throws ExceptionLogAcessoEscrita {
        this.regraNegocioLogAcesso.gerarLogAcesso(logAcesso);
    }

    @Override
    public List<LogAcesso> listarLogsAcesso() throws ExceptionLogAcessoLeitura {
       return this.regraNegocioLogAcesso.listarLogsAcesso();
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(Long codigoUsuario) throws ExceptionLogAcessoLeitura {
       return this.regraNegocioLogAcesso.filtrarLogAcessoCodigoUsuario(codigoUsuario);
    }

    @Override
    public LogAcesso filtrarLogAcessoDataAndHoraAcesso(Date diaAcesso, Date horaAcesso) throws ExceptionLogAcessoLeitura {
       return this.regraNegocioLogAcesso.filtrarLogAcessoDataAndHoraAcesso(diaAcesso, horaAcesso);
    }

    @Override
    public List<LogAcesso> filtrarLogAcessoData(Date diaAcesso) throws ExceptionLogAcessoLeitura {
       return this.regraNegocioLogAcesso.filtrarLogAcessoData(diaAcesso);
    }

    @Override
    public LogAcesso filtrarLogAcessoCodigo(int codigoLogAcesso) throws ExceptionLogAcessoLeitura {
        return this.regraNegocioLogAcesso.filtrarLogAcessoCodigo(codigoLogAcesso);
    }

    @Override
    public void cadastrarMedico(Medicos medico) throws ExceptionMedicosEscrita {
        this.regraNegocioMedicos.cadastrarMedico(medico);
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionMedicosEscrita {
      this.regraNegocioMedicos.atualizarMedico(medico);
    }

    @Override
    public void deletarMedico(Long cpf) throws ExceptionMedicosEscrita {
        this.regraNegocioMedicos.deletarMedico(cpf);
    }

    @Override
    public List<Medicos> listarMedicos() throws ExceptionMedicosLeitura {
       return this.regraNegocioMedicos.listarMedicos();
    }

    @Override
    public List<Medicos> filtrarMedicoNome(String nome) throws ExceptionMedicosLeitura {
      return this.regraNegocioMedicos.filtrarMedicoNome(nome);
    }

    @Override
    public List<Medicos> filtrarMedicoEspecialidade(String especialidade) throws ExceptionMedicosLeitura {
       return this.regraNegocioMedicos.filtrarMedicoEspecialidade(especialidade);
    }

    @Override
    public Medicos filtrarMedicoCpf(Long cpf) throws ExceptionMedicosLeitura {
        return this.regraNegocioMedicos.filtrarMedicoCpf(cpf);
    }

    @Override
    public Medicos filtrarMedicoUsuarioSenha(String usuario, String senha) throws ExceptionMedicosLeitura {
       return this.regraNegocioMedicos.filtrarMedicoUsuarioSenha(usuario, senha);
    }

    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionPacientesEscrita {
       this.regraNegocioPacientes.cadastrarPaciente(paciente);
    }

    @Override
    public void atualizarPacientes(Pacientes paciente) throws ExceptionPacientesEscrita {
      this.regraNegocioPacientes.atualizarPacientes(paciente);
    }

    @Override
    public void deletarPaciente(Long cpf) throws ExceptionPacientesEscrita {
       this.regraNegocioPacientes.deletarPaciente(cpf);
    }

    @Override
    public List<Pacientes> listarPacientes() throws ExceptionPacientesLeitura {
        return this.regraNegocioPacientes.listarPacientes();
    }

    @Override
    public List<Pacientes> filtrarPacientesNome(String nome) throws ExceptionPacientesLeitura {
      return this.regraNegocioPacientes.filtrarPacientesNome(nome);
    }

    @Override
    public Pacientes filtrarPacientesLoginNomeAndSenha(String loginNome, String senha) throws ExceptionPacientesLeitura {
       return this.regraNegocioPacientes.filtrarPacientesLoginNomeAndSenha(loginNome, senha);
    }

    @Override
    public Pacientes filtrarPacientesCpf(Long cpf) throws ExceptionPacientesLeitura {
       return this.regraNegocioPacientes.filtrarPacientesCpf(cpf);
    }

    @Override
    public void receitarMedicamentoPaciente(Long cpfPaciente, int codigoMedcicamento) throws ExceptionPacientesEscrita {
        this.regraNegocioPacientes.receitarMedicamentoPaciente(cpfPaciente, codigoMedcicamento);
    }

    @Override
    public void marcarExamePaciente(Long cpfPaciente, int codigoExame) throws ExceptionPacientesEscrita {
       this.regraNegocioPacientes.marcarExamePaciente(cpfPaciente, codigoExame);
    }

    @Override
    public void InserirConvenioPaciente(Long cpfPaciente, int codigoConvenio) throws ExceptionPacientesEscrita {
       this.regraNegocioPacientes.InserirConvenioPaciente(cpfPaciente, codigoConvenio);
    }

    @Override
    public void gerarProntuario(Prontuarios prontuario, int codigoExame, Long cpfPaciente, int codigoMedicamento) throws ExceptionProntuariosEscrita {
      this.regraNegocioProntuarios.gerarProntuario(prontuario, codigoExame, cpfPaciente, codigoMedicamento);
    }

    @Override
    public void atualizarProntuario(Prontuarios prontuarios) throws ExceptionProntuariosEscrita {
       this.regraNegocioProntuarios.atualizarProntuario(prontuarios);
    }

    @Override
    public void deletarProntuario(int codigoProntuario) throws ExceptionProntuariosEscrita {
        this.regraNegocioProntuarios.deletarProntuario(codigoProntuario);
    }

    @Override
    public Prontuarios filtrarProntuarioCodigo(int codigoProntuario) throws ExceptionProntuariosLeitura {
       return this.regraNegocioProntuarios.filtrarProntuarioCodigo(codigoProntuario);
    }

    @Override
    public void gerarReceita(Receitas receita, Long cpfMedico, Long cpfPaciente) throws ExceptionReceitasEscrita {
       this.regraNegocioReceitas.gerarReceita(receita, cpfMedico, cpfPaciente);
    }

    @Override
    public void atualizarReceita(Receitas receita) throws ExceptionReceitasEscrita {
       this.regraNegocioReceitas.atualizarReceita(receita);
    }

    @Override
    public void deletarReceita(int codigoReceita) throws ExceptionReceitasEscrita {
       this.regraNegocioReceitas.deletarReceita(codigoReceita);
    }

    @Override
    public Receitas filtrarReceitaCodigo(int codigoReceita) throws ExceptionReceitasLeitura {
       return this.regraNegocioReceitas.filtrarReceitaCodigo(codigoReceita);
    }

    @Override
    public void inserirExameReceita(int codigoReceita, int codigoExame) throws ExceptionReceitasEscrita {
      this.regraNegocioReceitas.inserirExameReceita(codigoReceita, codigoExame);
    }

    @Override
    public void inserirMedicamentoReceita(int codigoReceita, int codigoMedicamento) throws ExceptionReceitasEscrita {
        this.regraNegocioReceitas.inserirMedicamentoReceita(codigoReceita, codigoMedicamento);
    }
    
    
}
