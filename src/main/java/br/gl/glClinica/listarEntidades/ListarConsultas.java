
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Consultas;
import java.util.Date;

/**
 *
 * @author manoel
 */
public class ListarConsultas {
    
    private int codigoConsulta;
    private Date dataConsulta;
    private Date horaConsulta;
    private ListarPacientes paciente;
    private ListarMedicos medico;
    private ListarTiposConsultas tipoConsulta;

    public ListarConsultas() {       
    }
    
    public ListarConsultas(Consultas consulta) {
       this.codigoConsulta = consulta.getCodigoConsulta();
       this.dataConsulta = consulta.getDataConsulta();
       this.horaConsulta = consulta.getHoraConsulta();
       
          if(consulta.getPaciente()!=null) {
            this.paciente = new ListarPacientes();
              this.paciente.setCpf(consulta.getPaciente().getCpf());
              this.paciente.setDataNascimento(consulta.getPaciente().getDataNascimento());
              this.paciente.setEmail(consulta.getPaciente().getEmail());
              this.paciente.setEndereco(consulta.getPaciente().getEndereco());
              this.paciente.setLoginNome(consulta.getPaciente().getLoginNome());
              this.paciente.setNome(consulta.getPaciente().getNome());
              this.paciente.setNomeMae(consulta.getPaciente().getNomeMae());
              this.paciente.setNomePai(consulta.getPaciente().getNomePai());
              this.paciente.setNumeroCarteira(consulta.getPaciente().getNumeroCarteira());
              this.paciente.setQuantidadeAcessos(consulta.getPaciente().getQuantidadeAcessos());
              this.paciente.setRg(consulta.getPaciente().getRg());
              this.paciente.setSenha(consulta.getPaciente().getSenha());
              this.paciente.setSexo(consulta.getPaciente().getSexo());
              this.paciente.setTelefoneCelular(consulta.getPaciente().getTelefoneCelular());
              this.paciente.setTelefoneFixo(consulta.getPaciente().getTelefoneFixo());
          }
              if(consulta.getMedico()!=null) {
                this.medico = new ListarMedicos();
                  this.medico.setContadorAcessos(consulta.getMedico().getContadorAcessos());
                  this.medico.setCpf(consulta.getMedico().getCpf());
                  this.medico.setCrm(consulta.getMedico().getCrm());
                  this.medico.setEndereco(consulta.getMedico().getEndereco());
                  this.medico.setEspecialidades(consulta.getMedico().getEspecialidades());
                  this.medico.setNome(consulta.getMedico().getNome());
                  this.medico.setNomeUsuario(consulta.getMedico().getNomeUsuario());
                  this.medico.setRg(consulta.getMedico().getRg());
                  this.medico.setSenhaAcesso(consulta.getMedico().getSenhaAcesso());
                  this.medico.setTelefone(consulta.getMedico().getTelefone());
                  this.medico.setTelefoneResidencial(consulta.getMedico().getTelefoneResidencial());
              }
              
              if(consulta.getTipoConsulta()!=null) {
                this.tipoConsulta = new ListarTiposConsultas();
                  this.tipoConsulta.setCodigoTipoConsulta(consulta.getTipoConsulta().getCodigoTipoConsulta());
                  this.tipoConsulta.setNomeTipoConsulta(consulta.getTipoConsulta().getNomeTipoConsulta());
                  this.tipoConsulta.setValorTipoConsulta(consulta.getTipoConsulta().getValorTipoConsulta());
              }
    }
    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public ListarPacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(ListarPacientes paciente) {
        this.paciente = paciente;
    }

    public ListarMedicos getMedico() {
        return medico;
    }

    public void setMedico(ListarMedicos medico) {
        this.medico = medico;
    }

    public ListarTiposConsultas getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(ListarTiposConsultas tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    
   
}
