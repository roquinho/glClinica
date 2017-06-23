
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Receitas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarReceitas {
   
    private int codigoReceita;
    private Date dataReceita;
    private List<ListarMedicamentos> medicamentos;
    private ListarPacientes paciente;
    private List<ListarExames> exames;
    private ListarMedicos medico;
    
    public ListarReceitas() {
    }
    
    public ListarReceitas(Receitas receitas) {
        this.codigoReceita = receitas.getCodigoReceita();
        this.dataReceita = receitas.getDataReceita();
        
          if(receitas.getExames()!=null) {
            this.exames = new ArrayList<>();
             for(int i=0; i<receitas.getExames().size(); i++) {
                 ListarExames listaExames = new ListarExames(receitas.getExames().get(i));
                  this.exames.add(listaExames);
             }
          }
          if(receitas.getMedicamentos()!=null) {
              this.medicamentos = new ArrayList<>();
               for(int i=0;i<receitas.getMedicamentos().size(); i++) {
                   ListarMedicamentos listaMedicamentos = new ListarMedicamentos(receitas.getMedicamentos().get(i));
                     this.medicamentos.add(listaMedicamentos);
               } 
          }
          if(receitas.getMedico()!=null) {
              this.medico = new ListarMedicos();
              
                  this.medico.setContadorAcessos(receitas.getMedico().getContadorAcessos());
                  this.medico.setCpf(receitas.getMedico().getCpf());
                  this.medico.setCrm(receitas.getMedico().getCrm());
                  this.medico.setEndereco(receitas.getMedico().getEndereco());
                  this.medico.setEspecialidades(receitas.getMedico().getEspecialidades());
                  this.medico.setNome(receitas.getMedico().getNome());
                  this.medico.setNomeUsuario(receitas.getMedico().getNomeUsuario());
                  this.medico.setRg(receitas.getMedico().getRg());
                  this.medico.setSenhaAcesso(receitas.getMedico().getSenhaAcesso());
                  this.medico.setTelefone(receitas.getMedico().getTelefone());
                  this.medico.setTelefoneResidencial(receitas.getMedico().getTelefoneResidencial());   
          }
          if(receitas.getPaciente()!=null) {
               this.paciente = new ListarPacientes();
               
              this.paciente.setCpf(receitas.getPaciente().getCpf());
              this.paciente.setDataNascimento(receitas.getPaciente().getDataNascimento());
              this.paciente.setEmail(receitas.getPaciente().getEmail());
              this.paciente.setEndereco(receitas.getPaciente().getEndereco());
              this.paciente.setLoginNome(receitas.getPaciente().getLoginNome());
              this.paciente.setNome(receitas.getPaciente().getNome());
              this.paciente.setNomeMae(receitas.getPaciente().getNomeMae());
              this.paciente.setNomePai(receitas.getPaciente().getNomePai());
              this.paciente.setNumeroCarteira(receitas.getPaciente().getNumeroCarteira());
              this.paciente.setQuantidadeAcessos(receitas.getPaciente().getQuantidadeAcessos());
              this.paciente.setRg(receitas.getPaciente().getRg());
              this.paciente.setSenha(receitas.getPaciente().getSenha());
              this.paciente.setSexo(receitas.getPaciente().getSexo());
              this.paciente.setTelefoneCelular(receitas.getPaciente().getTelefoneCelular());
              this.paciente.setTelefoneFixo(receitas.getPaciente().getTelefoneFixo());
                 
          }
          
    }

    public int getCodigoReceita() {
        return codigoReceita;
    }

    public void setCodigoReceita(int codigoReceita) {
        this.codigoReceita = codigoReceita;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public List<ListarMedicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<ListarMedicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ListarPacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(ListarPacientes paciente) {
        this.paciente = paciente;
    }

    public List<ListarExames> getExames() {
        return exames;
    }

    public void setExames(List<ListarExames> exames) {
        this.exames = exames;
    }

    public ListarMedicos getMedico() {
        return medico;
    }

    public void setMedico(ListarMedicos medico) {
        this.medico = medico;
    }
    
    

}
