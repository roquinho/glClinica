
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author manoel
 */
@Entity
public class Medicos implements Serializable{
   
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
    private List<Receitas> receitas;
    private List<Laudos> laudos;
    private List<Consultas> consultas;
   // private List<Clinica> clinicas;
    
       public Medicos() {       
        }

    public Medicos(Long cpf, String nome, Long rg, Long crm, String nomeUsuario, String senhaAcesso, Long telefone, String telefoneResidencial, String especialidades, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.crm = crm;
        this.nomeUsuario = nomeUsuario;
        this.senhaAcesso = senhaAcesso;
        this.telefone = telefone;
        this.telefoneResidencial = telefoneResidencial;
        this.especialidades = especialidades;
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.rg);
        hash = 79 * hash + Objects.hashCode(this.crm);
        hash = 79 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 79 * hash + Objects.hashCode(this.senhaAcesso);
        hash = 79 * hash + this.contadorAcessos;
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.telefoneResidencial);
        hash = 79 * hash + Objects.hashCode(this.especialidades);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.receitas);
        hash = 79 * hash + Objects.hashCode(this.laudos);
        hash = 79 * hash + Objects.hashCode(this.consultas);
        //hash = 79 * hash + Objects.hashCode(this.clinicas);
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
        final Medicos other = (Medicos) obj;
        if (this.contadorAcessos != other.contadorAcessos) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.senhaAcesso, other.senhaAcesso)) {
            return false;
        }
        if (!Objects.equals(this.telefoneResidencial, other.telefoneResidencial)) {
            return false;
        }
        if (!Objects.equals(this.especialidades, other.especialidades)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
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
        /*if (!Objects.equals(this.clinicas, other.clinicas)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Medicos{" + "cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", crm=" + crm + ", nomeUsuario=" + nomeUsuario + ", senhaAcesso=" + senhaAcesso + ", contadorAcessos=" + contadorAcessos + ", telefone=" + telefone + ", telefoneResidencial=" + telefoneResidencial + ", especialidades=" + especialidades + ", endereco=" + endereco + ", receitas=" + receitas + ", laudos=" + laudos + ", consultas=" + consultas + '}';
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
    @OneToMany(fetch = FetchType.EAGER,mappedBy="medico",cascade = CascadeType.REMOVE)//lazy
    public List<Receitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receitas> receitas) {
        this.receitas = receitas;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="medico",cascade = CascadeType.REMOVE)//lazy
    public List<Laudos> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<Laudos> laudos) {
        this.laudos = laudos;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="medico",cascade = CascadeType.REMOVE)//lazy
    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }

    /*public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }*/
       
}

