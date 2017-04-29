
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Cargos;
import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionCargosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionCargosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface Fachada extends Serializable {
    
    public void cadastrarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void atualizarCargo(Cargos cargo)throws ExceptionCargosEscrita;
    
    public void deletarCargo(int codigoCargo)throws ExceptionCargosEscrita;
    
    public List<Cargos> listarCargos()throws ExceptionCargosLeitura;
    
    public Cargos filtrarCargoCodigo(int codigoCargo)throws ExceptionCargosLeitura;
    
    public List<Cargos> filtrarCargoNome(String nomeCargo)throws ExceptionCargosLeitura;
    
    
    
    public void cadastrarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void atualizarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void deletarClinica(Long cnpj)throws ExceptionClinicaEscrita;
    
    public List<Clinica> listarClinicas()throws ExceptionClinicaLeitura;
    
    public List<Clinica> filtrarClinicaNome(String nome)throws ExceptionClinicaLeitura;
    
    public Clinica filtrarClinicaCnpj(Long cnpj)throws ExceptionClinicaLeitura;
    
    
    
  public void cadastrarFuncionario(Funcionarios fincionario, int codigoCargo)throws ExceptionFuncionariosEscrita;
  
  public void atualizarFuncionario(Funcionarios funcionario)throws ExceptionFuncionariosEscrita;
  
  public void deletarFuncionario(Long cpf)throws ExceptionFuncionariosEscrita;
  
  public List<Funcionarios> listarFuncionarios()throws ExceptionFuncionariosLeitura;
  
  public List<Funcionarios> filtrarFuncionariosNome(String nome)throws ExceptionFuncionariosLeitura;
  
  public Funcionarios filtrarFuncionarioCpf(Long cpf)throws ExceptionFuncionariosLeitura;
  
  public Funcionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha)throws ExceptionFuncionariosLeitura;
  

    public void cadastrarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void atualizarConvenio(Convenios convenio)throws ExceptionConveniosEscrita;
    
    public void deletarConvenio(int codigoConvenio)throws ExceptionConveniosEscrita;
    
    public List<Convenios> listarConvenios()throws ExceptionConveniosLeitura;
    
    public List<Convenios> filtrarConvenioNome(String nomeConvenio)throws ExceptionConveniosLeitura;
    
    public Convenios filtrarConvenioCodigo(int codigoConvenio)throws ExceptionConveniosLeitura;
    
    
        
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
    
  
}
