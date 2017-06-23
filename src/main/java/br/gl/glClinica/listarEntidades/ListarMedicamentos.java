
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Medicamentos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarMedicamentos {
    
    private int codigoMedicamento;
    private String nomeMedicamento;
    private String substanciaAtiva;
    private String posologiaIndicada;
    private String nomeLaboratorio;
    private String contraIndicacoes;
    private String generico;
    private List<ListarProntuarios> prontuarios;
    private List<ListarReceitas> receitas;
    private List<ListarPacientes> pacientes;
    
    public ListarMedicamentos() {        
    }
    
    public ListarMedicamentos(Medicamentos medicamentos) {
        this.codigoMedicamento = medicamentos.getCodigoMedicamento();
        this.contraIndicacoes = medicamentos.getContraIndicacoes();
        this.generico = medicamentos.getGenerico();
        this.nomeLaboratorio = medicamentos.getNomeLaboratorio();
        this.nomeMedicamento = medicamentos.getNomeMedicamento();
        this.posologiaIndicada = medicamentos.getPosologiaIndicada();
        this.substanciaAtiva = medicamentos.getSubstanciaAtiva();
        
        if(medicamentos.getProntuarios()!=null) {
           this.prontuarios = new ArrayList<>();
             for(int i=0; i<medicamentos.getProntuarios().size(); i++) {
                ListarProntuarios listaProntuarios = new ListarProntuarios(medicamentos.getProntuarios().get(i));
                 this.prontuarios.add(listaProntuarios);
             }
        }
        if(medicamentos.getReceitas()!=null) {
            this.receitas = new ArrayList<>();
              for(int i=0; i<medicamentos.getReceitas().size(); i++) {
                  ListarReceitas listaReceitas = new ListarReceitas();
                    this.receitas.add(listaReceitas);
                      
                        this.receitas.get(i).setCodigoReceita(medicamentos.getReceitas().get(i).getCodigoReceita());
                        this.receitas.get(i).setDataReceita(medicamentos.getReceitas().get(i).getDataReceita());
                      
              }
        }
        if(medicamentos.getPacientes()!=null) {
            this.pacientes = new ArrayList<>();
              for(int i=0; i<medicamentos.getPacientes().size(); i++) {
                  ListarPacientes listaPacientes = new ListarPacientes();
                    this.pacientes.add(listaPacientes);
                    
                      this.pacientes.get(i).setCpf(medicamentos.getPacientes().get(i).getCpf());
                      this.pacientes.get(i).setDataNascimento(medicamentos.getPacientes().get(i).getDataNascimento());
                      this.pacientes.get(i).setEmail(medicamentos.getPacientes().get(i).getEmail());
                      this.pacientes.get(i).setEndereco(medicamentos.getPacientes().get(i).getEndereco());
                      this.pacientes.get(i).setLoginNome(medicamentos.getPacientes().get(i).getLoginNome());
                      this.pacientes.get(i).setNome(medicamentos.getPacientes().get(i).getNome());
                      this.pacientes.get(i).setNomeMae(medicamentos.getPacientes().get(i).getNomeMae());
                      this.pacientes.get(i).setNomePai(medicamentos.getPacientes().get(i).getNomePai());
                      this.pacientes.get(i).setNumeroCarteira(medicamentos.getPacientes().get(i).getNumeroCarteira());
                      this.pacientes.get(i).setQuantidadeAcessos(medicamentos.getPacientes().get(i).getQuantidadeAcessos());
                      this.pacientes.get(i).setRg(medicamentos.getPacientes().get(i).getRg());
                      this.pacientes.get(i).setSenha(medicamentos.getPacientes().get(i).getSenha());
                      this.pacientes.get(i).setSexo(medicamentos.getPacientes().get(i).getSexo());
                      this.pacientes.get(i).setTelefoneCelular(medicamentos.getPacientes().get(i).getTelefoneCelular());
                      this.pacientes.get(i).setTelefoneFixo(medicamentos.getPacientes().get(i).getTelefoneFixo());
              }
        }
     }

    public int getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(int codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getSubstanciaAtiva() {
        return substanciaAtiva;
    }

    public void setSubstanciaAtiva(String substanciaAtiva) {
        this.substanciaAtiva = substanciaAtiva;
    }

    public String getPosologiaIndicada() {
        return posologiaIndicada;
    }

    public void setPosologiaIndicada(String posologiaIndicada) {
        this.posologiaIndicada = posologiaIndicada;
    }

    public String getNomeLaboratorio() {
        return nomeLaboratorio;
    }

    public void setNomeLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public List<ListarProntuarios> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<ListarProntuarios> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List<ListarReceitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ListarReceitas> receitas) {
        this.receitas = receitas;
    }

    public List<ListarPacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<ListarPacientes> pacientes) {
        this.pacientes = pacientes;
    }
    
    
    
}
