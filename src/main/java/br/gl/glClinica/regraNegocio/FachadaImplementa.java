
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
    public List<Cargos> listarCargos() throws ExceptionCargosLeitura {
      return this.regraNegocioCargos.listarCargos();
    }

    @Override
    public Cargos filtrarCargoCodigo(int codigoCargo) throws ExceptionCargosLeitura {
      return this.regraNegocioCargos.filtrarCargoCodigo(codigoCargo);
    }

    @Override
    public List<Cargos> filtrarCargoNome(String nomeCargo) throws ExceptionCargosLeitura {
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
    public void deletarClinica(Long cnpj) throws ExceptionClinicaEscrita {
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
    public Clinica filtrarClinicaCnpj(Long cnpj) throws ExceptionClinicaLeitura {
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
    public List<Funcionarios> listarFuncionarios() throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.listarFuncionarios();
    }

    @Override
    public List<Funcionarios> filtrarFuncionariosNome(String nome) throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.filtrarFuncionariosNome(nome);
    }

    @Override
    public Funcionarios filtrarFuncionarioCpf(Long cpf) throws ExceptionFuncionariosLeitura {
        return this.regraNegocioFuncionarios.filtrarFuncionarioCpf(cpf);
    }

    @Override
    public Funcionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha) throws ExceptionFuncionariosLeitura {
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
    
    
}
