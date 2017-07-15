
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class Pacientes implements Serializable{
  
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
        private List<Medicamentos> medicamentos;
        private List<Convenios> convenios;
        private List<Exames> exames;
        private List<Prontuarios> prontuarios;
        private List<Receitas> receitas;
        private List<Laudos> laudos;
        private List<Consultas> consultas;
        //private Clinica clinica;
        
            public Pacientes() {
             }  

    public Pacientes(String nome, Date dataNascimento, String sexo, Long cpf, String endereco, String telefoneCelular, String loginNome, String senha, Long rg, String nomePai, String nomeMae, Long numeroCarteira, String telefoneFixo, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefoneCelular = telefoneCelular;
        this.loginNome = loginNome;
        this.senha = senha;
        this.rg = rg;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.numeroCarteira = numeroCarteira;
        this.telefoneFixo = telefoneFixo;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.endereco);
        hash = 97 * hash + Objects.hashCode(this.telefoneCelular);
        hash = 97 * hash + Objects.hashCode(this.loginNome);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.rg);
        hash = 97 * hash + Objects.hashCode(this.nomePai);
        hash = 97 * hash + Objects.hashCode(this.nomeMae);
        hash = 97 * hash + Objects.hashCode(this.numeroCarteira);
        hash = 97 * hash + Objects.hashCode(this.telefoneFixo);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + this.quantidadeAcessos;
        hash = 97 * hash + Objects.hashCode(this.medicamentos);
        hash = 97 * hash + Objects.hashCode(this.convenios);
        hash = 97 * hash + Objects.hashCode(this.exames);
        hash = 97 * hash + Objects.hashCode(this.prontuarios);
        hash = 97 * hash + Objects.hashCode(this.receitas);
        hash = 97 * hash + Objects.hashCode(this.laudos);
        hash = 97 * hash + Objects.hashCode(this.consultas);
        //hash = 97 * hash + Objects.hashCode(this.clinica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pacientes other = (Pacientes) obj;
        if (this.quantidadeAcessos != other.quantidadeAcessos) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCelular, other.telefoneCelular)) {
            return false;
        }
        if (!Objects.equals(this.loginNome, other.loginNome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.telefoneFixo, other.telefoneFixo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.numeroCarteira, other.numeroCarteira)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.convenios, other.convenios)) {
            return false;
        }
        if (!Objects.equals(this.exames, other.exames)) {
            return false;
        }
        if (!Objects.equals(this.prontuarios, other.prontuarios)) {
            return false;
        }
        if (!Objects.equals(this.receitas, other.receitas)) {
            return false;
        }
        if (!Objects.equals(this.laudos, other.laudos)) {
            return false;
        }
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        /*if (!Objects.equals(this.clinica, other.clinica)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", endereco=" + endereco + ", telefoneCelular=" + telefoneCelular + ", loginNome=" + loginNome + ", senha=" + senha + ", rg=" + rg + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", numeroCarteira=" + numeroCarteira + ", telefoneFixo=" + telefoneFixo + ", email=" + email + ", quantidadeAcessos=" + quantidadeAcessos + ", medicamentos=" + medicamentos + ", convenios=" + convenios + ", exames=" + exames + ", prontuarios=" + prontuarios + ", receitas=" + receitas + ", laudos=" + laudos + ", consultas=" + consultas + '}';
    }
    
    @Id
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

    @Temporal(TemporalType.DATE)
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
    
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Convenios> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenios> convenios) {
        this.convenios = convenios;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Exames> getExames() {
        return exames;
    }

    public void setExames(List<Exames> exames) {
        this.exames = exames;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="paciente",cascade = CascadeType.REMOVE)
    public List<Prontuarios> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuarios> prontuarios) {
        this.prontuarios = prontuarios;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="paciente",cascade = CascadeType.REMOVE)
    public List<Receitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receitas> receitas) {
        this.receitas = receitas;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="paciente",cascade = CascadeType.REMOVE)
    public List<Laudos> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<Laudos> laudos) {
        this.laudos = laudos;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="paciente",cascade = CascadeType.REMOVE)
    public List<Consultas> getConsultas() {
        return consultas;
    }
    
    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }
     
    /*public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }*/
            
            
}
