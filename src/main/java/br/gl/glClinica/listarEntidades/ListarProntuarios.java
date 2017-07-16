
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Prontuarios;
import java.util.Date;

/**
 *
 * @author manoel
 */
public class ListarProntuarios {
   
    private int codigoProntuario;
    private String observacoes;
    private Date dataInicioTratamento;
    private Date dataFimTratamento;
    private ListarPacientes paciente;
    
    public ListarProntuarios() {
    }
    
    public ListarProntuarios(Prontuarios prontuarios) {
        this.codigoProntuario = prontuarios.getCodigoProntuario();
        this.dataFimTratamento = prontuarios.getDataFimTratamento();
        this.dataInicioTratamento = prontuarios.getDataInicioTratamento();
        this.observacoes = prontuarios.getObservacoes();
        
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public ListarPacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(ListarPacientes paciente) {
        this.paciente = paciente;
    }
    
}
