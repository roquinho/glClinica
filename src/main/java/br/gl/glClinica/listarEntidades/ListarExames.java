
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Exames;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarExames {
    
    private int codigoExame;
    private String nomeExame;
    private String observacoesExame;
    private List<ListarProntuarios> prontuarios;
    private List<ListarPacientes> pacientes;
    private List<ListarReceitas> receitas;
    
    public ListarExames() {
    }
    
    public ListarExames(Exames exames) {
        this.codigoExame = exames.getCodigoExame();
        this.nomeExame = exames.getNomeExame();
        this.observacoesExame = exames.getObservacoesExame();
        
          if(exames.getProntuarios()!=null) {
              this.prontuarios = new ArrayList<>();
                for(int i=0; i<exames.getProntuarios().size(); i++) {
                    ListarProntuarios listaProntuarios = new ListarProntuarios(exames.getProntuarios().get(i));
                      this.prontuarios.add(listaProntuarios);
                }
          }
          if(exames.getPacientes()!=null) {
              this.pacientes = new ArrayList<>();
                for(int i=0; i<exames.getPacientes().size(); i++) {
                  ListarPacientes paciente = new ListarPacientes();
                    this.pacientes.add(paciente);
                      
                       this.pacientes.get(i).setCpf(exames.getPacientes().get(i).getCpf());
                       this.pacientes.get(i).setDataNascimento(exames.getPacientes().get(i).getDataNascimento());
                       this.pacientes.get(i).setEmail(exames.getPacientes().get(i).getEmail());
                       this.pacientes.get(i).setEndereco(exames.getPacientes().get(i).getEndereco());
                       this.pacientes.get(i).setLoginNome(exames.getPacientes().get(i).getLoginNome());
                       this.pacientes.get(i).setNome(exames.getPacientes().get(i).getNome());
                       this.pacientes.get(i).setNomeMae(exames.getPacientes().get(i).getNomeMae());
                       this.pacientes.get(i).setNomePai(exames.getPacientes().get(i).getNomePai());
                       this.pacientes.get(i).setNumeroCarteira(exames.getPacientes().get(i).getNumeroCarteira());
                       this.pacientes.get(i).setQuantidadeAcessos(exames.getPacientes().get(i).getQuantidadeAcessos());
                       this.pacientes.get(i).setRg(exames.getPacientes().get(i).getRg());
                       this.pacientes.get(i).setSenha(exames.getPacientes().get(i).getSenha());
                       this.pacientes.get(i).setSexo(exames.getPacientes().get(i).getSexo());
                       this.pacientes.get(i).setTelefoneCelular(exames.getPacientes().get(i).getTelefoneCelular());
                       this.pacientes.get(i).setTelefoneFixo(exames.getPacientes().get(i).getTelefoneFixo());
                       
                }
          }
          if(exames.getReceitas()!=null) {
              this.receitas = new ArrayList<>();
                for(int i=0; i<exames.getReceitas().size(); i++) {
                    ListarReceitas listaReceitas = new ListarReceitas();
                      this.receitas.add(listaReceitas);
                      
                        this.receitas.get(i).setCodigoReceita(exames.getReceitas().get(i).getCodigoReceita());
                        this.receitas.get(i).setDataReceita(exames.getReceitas().get(i).getDataReceita());
                }
          }
    }

    public int getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(int codigoExame) {
        this.codigoExame = codigoExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getObservacoesExame() {
        return observacoesExame;
    }

    public void setObservacoesExame(String observacoesExame) {
        this.observacoesExame = observacoesExame;
    }

    public List<ListarProntuarios> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<ListarProntuarios> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List<ListarPacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<ListarPacientes> pacientes) {
        this.pacientes = pacientes;
    }

    public List<ListarReceitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ListarReceitas> receitas) {
        this.receitas = receitas;
    }
    
    
  
}
