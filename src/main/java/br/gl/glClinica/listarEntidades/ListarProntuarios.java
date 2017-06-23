
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Prontuarios;
import java.util.Date;

/**
 *
 * @author manoel
 */
public class ListarProntuarios {
   
    private int codigoProntuario;
    private String posologiaReceitada;
    private String observacoes;
    private String resultadoExame;
    private Date dataExame;
    private Date dataInicioTratamento;
    private Date dataFimTratamento;
    private ListarExames exame;
    private ListarPacientes paciente;
    private ListarMedicamentos medicamento;
    
    public ListarProntuarios() {
    }
    
    public ListarProntuarios(Prontuarios prontuarios) {
        this.codigoProntuario = prontuarios.getCodigoProntuario();
        this.dataExame = prontuarios.getDataExame();
        this.dataFimTratamento = prontuarios.getDataFimTratamento();
        this.dataInicioTratamento = prontuarios.getDataInicioTratamento();
        this.observacoes = prontuarios.getObservacoes();
        this.posologiaReceitada = prontuarios.getPosologiaReceitada();
        this.resultadoExame = prontuarios.getResultadoExame();
        
           if(prontuarios.getExame()!=null) {
               this.exame = new ListarExames();
                 
                this.exame.setCodigoExame(prontuarios.getExame().getCodigoExame());
                this.exame.setNomeExame(prontuarios.getExame().getNomeExame());
                this.exame.setObservacoesExame(prontuarios.getExame().getObservacoesExame());
           }
           if(prontuarios.getMedicamento()!=null) {
               this.medicamento = new ListarMedicamentos();
               
                 this.medicamento.setCodigoMedicamento(prontuarios.getMedicamento().getCodigoMedicamento());
                 this.medicamento.setContraIndicacoes(prontuarios.getMedicamento().getContraIndicacoes());
                 this.medicamento.setGenerico(prontuarios.getMedicamento().getGenerico());
                 this.medicamento.setNomeLaboratorio(prontuarios.getMedicamento().getNomeLaboratorio());
                 this.medicamento.setNomeMedicamento(prontuarios.getMedicamento().getNomeMedicamento());
                 this.medicamento.setPosologiaIndicada(prontuarios.getMedicamento().getPosologiaIndicada());
                 this.medicamento.setSubstanciaAtiva(prontuarios.getMedicamento().getSubstanciaAtiva());
           }
           if(prontuarios.getPaciente()!=null) {
               this.paciente = new ListarPacientes();
               
              this.paciente.setCpf(prontuarios.getPaciente().getCpf());
              this.paciente.setDataNascimento(prontuarios.getPaciente().getDataNascimento());
              this.paciente.setEmail(prontuarios.getPaciente().getEmail());
              this.paciente.setEndereco(prontuarios.getPaciente().getEndereco());
              this.paciente.setLoginNome(prontuarios.getPaciente().getLoginNome());
              this.paciente.setNome(prontuarios.getPaciente().getNome());
              this.paciente.setNomeMae(prontuarios.getPaciente().getNomeMae());
              this.paciente.setNomePai(prontuarios.getPaciente().getNomePai());
              this.paciente.setNumeroCarteira(prontuarios.getPaciente().getNumeroCarteira());
              this.paciente.setQuantidadeAcessos(prontuarios.getPaciente().getQuantidadeAcessos());
              this.paciente.setRg(prontuarios.getPaciente().getRg());
              this.paciente.setSenha(prontuarios.getPaciente().getSenha());
              this.paciente.setSexo(prontuarios.getPaciente().getSexo());
              this.paciente.setTelefoneCelular(prontuarios.getPaciente().getTelefoneCelular());
              this.paciente.setTelefoneFixo(prontuarios.getPaciente().getTelefoneFixo());
    
           }
    }

    public int getCodigoProntuario() {
        return codigoProntuario;
    }

    public void setCodigoProntuario(int codigoProntuario) {
        this.codigoProntuario = codigoProntuario;
    }

    public String getPosologiaReceitada() {
        return posologiaReceitada;
    }

    public void setPosologiaReceitada(String posologiaReceitada) {
        this.posologiaReceitada = posologiaReceitada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Date getDataInicioTratamento() {
        return dataInicioTratamento;
    }

    public void setDataInicioTratamento(Date dataInicioTratamento) {
        this.dataInicioTratamento = dataInicioTratamento;
    }

    public Date getDataFimTratamento() {
        return dataFimTratamento;
    }

    public void setDataFimTratamento(Date dataFimTratamento) {
        this.dataFimTratamento = dataFimTratamento;
    }

    public ListarExames getExame() {
        return exame;
    }

    public void setExame(ListarExames exame) {
        this.exame = exame;
    }

    public ListarPacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(ListarPacientes paciente) {
        this.paciente = paciente;
    }

    public ListarMedicamentos getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(ListarMedicamentos medicamento) {
        this.medicamento = medicamento;
    }
    
    

}
