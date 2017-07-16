
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Laudos;
import java.util.Date;

/**
 *
 * @author manoel
 */
public class ListarLaudos {
    
    private int codigoLaudo;
    private String descricaoLaudo;
    private Date dataLaudo;
    private Date horaLaudo;
    private Date dataExame;
    private ListarPacientes paciente;
    private ListarMedicos medico;
    private ListarExames exames;
    
    public ListarLaudos() {
    }
    
    public ListarLaudos(Laudos laudos) {
        this.codigoLaudo = laudos.getCodigoLaudo();
        this.dataLaudo = laudos.getDataLaudo();
        this.descricaoLaudo = laudos.getDescricaoLaudo();
        this.horaLaudo = laudos.getHoraLaudo();
        this.dataExame = laudos.getDataExame();
          
           if(laudos.getPaciente()!=null) {
            this.paciente = new ListarPacientes();              
              this.paciente.setCpf(laudos.getPaciente().getCpf());
              this.paciente.setDataNascimento(laudos.getPaciente().getDataNascimento());
              this.paciente.setEmail(laudos.getPaciente().getEmail());
              this.paciente.setEndereco(laudos.getPaciente().getEndereco());
              this.paciente.setLoginNome(laudos.getPaciente().getLoginNome());
              this.paciente.setNome(laudos.getPaciente().getNome());
              this.paciente.setNomeMae(laudos.getPaciente().getNomeMae());
              this.paciente.setNomePai(laudos.getPaciente().getNomePai());
              this.paciente.setNumeroCarteira(laudos.getPaciente().getNumeroCarteira());
              this.paciente.setQuantidadeAcessos(laudos.getPaciente().getQuantidadeAcessos());
              this.paciente.setRg(laudos.getPaciente().getRg());
              this.paciente.setSenha(laudos.getPaciente().getSenha());
              this.paciente.setSexo(laudos.getPaciente().getSexo());
              this.paciente.setTelefoneCelular(laudos.getPaciente().getTelefoneCelular());
              this.paciente.setTelefoneFixo(laudos.getPaciente().getTelefoneFixo());               
           }
           if(laudos.getMedico()!=null) {
               this.medico = new ListarMedicos();               
                 this.medico.setContadorAcessos(laudos.getMedico().getContadorAcessos());
                  this.medico.setCpf(laudos.getMedico().getCpf());
                  this.medico.setCrm(laudos.getMedico().getCrm());
                  this.medico.setEndereco(laudos.getMedico().getEndereco());
                  this.medico.setEspecialidades(laudos.getMedico().getEspecialidades());
                  this.medico.setNome(laudos.getMedico().getNome());
                  this.medico.setNomeUsuario(laudos.getMedico().getNomeUsuario());
                  this.medico.setRg(laudos.getMedico().getRg());
                  this.medico.setSenhaAcesso(laudos.getMedico().getSenhaAcesso());
                  this.medico.setTelefone(laudos.getMedico().getTelefone());
                  this.medico.setTelefoneResidencial(laudos.getMedico().getTelefoneResidencial());
           }
           if(laudos.getExame()!=null) {
               this.exames = new ListarExames();               
                 this.exames.setCodigoExame(laudos.getExame().getCodigoExame());
                 this.exames.setNomeExame(laudos.getExame().getNomeExame());
                 this.exames.setObservacoesExame(laudos.getExame().getObservacoesExame());
           }
    
    }

    public int getCodigoLaudo() {
        return codigoLaudo;
    }

    public void setCodigoLaudo(int codigoLaudo) {
        this.codigoLaudo = codigoLaudo;
    }

    public String getDescricaoLaudo() {
        return descricaoLaudo;
    }

    public void setDescricaoLaudo(String descricaoLaudo) {
        this.descricaoLaudo = descricaoLaudo;
    }

    public Date getDataLaudo() {
        return dataLaudo;
    }

    public void setDataLaudo(Date dataLaudo) {
        this.dataLaudo = dataLaudo;
    }

    public Date getHoraLaudo() {
        return horaLaudo;
    }

    public void setHoraLaudo(Date horaLaudo) {
        this.horaLaudo = horaLaudo;
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

    public ListarExames getExames() {
        return exames;
    }

    public void setExames(ListarExames exames) {
        this.exames = exames;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }
    
    
   
}
