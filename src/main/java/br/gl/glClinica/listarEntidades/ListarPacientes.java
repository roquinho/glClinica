
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Pacientes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarPacientes {
  
        private String nome;
	private Date dataNascimento;
	private String sexo;
	private Long cpf;
	private String endereco;
	private String telefoneCelular;
	private String loginNome;
	private String senha;
        private Long rg;
        private String nomePai;
        private String nomeMae;
        private Long numeroCarteira;
        private String telefoneFixo;
        private String email;
        private int quantidadeAcessos;
        private List<ListarMedicamentos> medicamentos;
        private List<ListarConvenios> convenios;
        private List<ListarExames> exames;
        private List<ListarProntuarios> prontuarios;
        private List<ListarReceitas> receitas;
        private List<ListarLaudos> laudos;
        private List<ListarConsultas> consultas;
        
        public ListarPacientes() {
        }
        
        public ListarPacientes(Pacientes paciente) {
            
          this.cpf = paciente.getCpf();
          this.dataNascimento = paciente.getDataNascimento();
          this.email = paciente.getEmail();
          this.endereco = paciente.getEndereco();
          this.loginNome = paciente.getLoginNome();
          this.nome = paciente.getNome();
          this.nomeMae = paciente.getNomeMae();
          this.nomePai = paciente.getNomePai();
          this.numeroCarteira = paciente.getNumeroCarteira();
          this.quantidadeAcessos = paciente.getQuantidadeAcessos();
          this.rg = paciente.getRg();
          this.senha = paciente.getSenha();
          this.sexo = paciente.getSexo();
          this.telefoneCelular = paciente.getTelefoneCelular();
          this.telefoneFixo = paciente.getTelefoneFixo();
          
          
             if(paciente.getConsultas()!=null) {
                this.consultas = new ArrayList<>(); 
                 for(int i=0; i<paciente.getConsultas().size(); i++) {
                   ListarConsultas listaConsultas = new ListarConsultas(paciente.getConsultas().get(i));
                     this.consultas.add(listaConsultas);
             }
        }
             if(paciente.getConvenios()!=null) {
                 this.convenios = new ArrayList<>();
                   for(int i=0; i<paciente.getConvenios().size();i++) {
                       ListarConvenios listaConvenios = new ListarConvenios(paciente.getConvenios().get(i));
                         this.convenios.add(listaConvenios);
                   }
             }
             if(paciente.getExames()!=null) {
                 this.exames = new ArrayList<>();
                   for(int i=0; i<paciente.getExames().size(); i++) {
                       ListarExames listaExames = new ListarExames(paciente.getExames().get(i));
                         this.exames.add(listaExames);
                   }
             }
             if(paciente.getLaudos()!=null) {
                 this.laudos = new ArrayList<>();
                   for(int i=0; i<paciente.getLaudos().size(); i++) {
                       ListarLaudos listarLaudos = new ListarLaudos(paciente.getLaudos().get(i));
                         this.laudos.add(listarLaudos);
                   }
             }
             if(paciente.getMedicamentos()!=null) {
                 this.medicamentos = new ArrayList<>();
                   for(int i=0; i<paciente.getMedicamentos().size(); i++) {
                       ListarMedicamentos listaMedicamentos = new ListarMedicamentos(paciente.getMedicamentos().get(i));
                         this.medicamentos.add(listaMedicamentos);
                   }
             }
        }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getLoginNome() {
        return loginNome;
    }

    public void setLoginNome(String loginNome) {
        this.loginNome = loginNome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Long getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(Long numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantidadeAcessos() {
        return quantidadeAcessos;
    }

    public void setQuantidadeAcessos(int quantidadeAcessos) {
        this.quantidadeAcessos = quantidadeAcessos;
    }

    public List<ListarMedicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<ListarMedicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<ListarConvenios> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<ListarConvenios> convenios) {
        this.convenios = convenios;
    }

    public List<ListarExames> getExames() {
        return exames;
    }

    public void setExames(List<ListarExames> exames) {
        this.exames = exames;
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
