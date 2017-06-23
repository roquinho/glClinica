
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Medicos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarMedicos {
  
    private Long cpf;
    private String nome;
    private Long rg;
    private Long crm;
    private String nomeUsuario;
    private String senhaAcesso;
    private int contadorAcessos;
    private Long telefone;
    private String telefoneResidencial;
    private String especialidades;
    private String endereco;
    private List<ListarReceitas> receitas;
    private List<ListarLaudos> laudos;
    private List<ListarConsultas> consultas;
    
    public ListarMedicos() {
    }
    
    public ListarMedicos(Medicos medico) {
        
        this.contadorAcessos = medico.getContadorAcessos();
        this.cpf = medico.getCpf();
        this.crm = medico.getCrm();
        this.endereco = medico.getEndereco();
        this.especialidades = medico.getEspecialidades();
        this.nome = medico.getNome();
        this.nomeUsuario = medico.getNomeUsuario();
        this.rg = medico.getRg();
        this.senhaAcesso = medico.getSenhaAcesso();
        this.telefone = medico.getTelefone();
        this.telefoneResidencial = medico.getTelefoneResidencial();
        
          if(medico.getConsultas()!=null) {
            this.consultas = new ArrayList<>();
             for(int i=0; i<medico.getConsultas().size(); i++) {
                 ListarConsultas listaConsultas = new ListarConsultas(medico.getConsultas().get(i));
                   this.consultas.add(listaConsultas);
             }
          }
          if(medico.getLaudos()!=null) {
              this.laudos = new ArrayList<>();
                for(int i=0; i<medico.getLaudos().size(); i++) {
                   ListarLaudos listaLaudos = new ListarLaudos(medico.getLaudos().get(i));
                     this.laudos.add(listaLaudos);
                }
          }
          if(medico.getReceitas()!=null) {
             this.receitas = new ArrayList<>();
               for(int i=0; i<medico.getReceitas().size(); i++) {
                   ListarReceitas listaReceitas = new ListarReceitas(medico.getReceitas().get(i));
                     this.receitas.add(listaReceitas);
               }
          }
    }
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public int getContadorAcessos() {
        return contadorAcessos;
    }

    public void setContadorAcessos(int contadorAcessos) {
        this.contadorAcessos = contadorAcessos;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ListarReceitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ListarReceitas> receitas) {
        this.receitas = receitas;
    }

    public List<ListarLaudos> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<ListarLaudos> laudos) {
        this.laudos = laudos;
    }

    public List<ListarConsultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ListarConsultas> consultas) {
        this.consultas = consultas;
    }
    
    
}
