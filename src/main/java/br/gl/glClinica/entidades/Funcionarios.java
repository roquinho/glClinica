
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class Funcionarios implements Serializable {
   
    private Long cpf;
    private String nome;
    private String endereco;
    private Long rg;
    private String telefoneCelular;
    private String telefoneFixo;
    private String nomeUsuario;
    private String senha;
    private Date dataCriacao;
    private int contadorAcesso;
    private Cargos cargo;
    //private Clinica clinica;

       public Funcionarios() {    
               }

    public Funcionarios(Long cpf, String nome, String endereco, Long rg, String telefoneCelular, String telefoneFixo, String nomeUsuario, String senha, Date dataCriacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.rg = rg;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.cpf);
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.endereco);
        hash = 61 * hash + Objects.hashCode(this.rg);
        hash = 61 * hash + Objects.hashCode(this.telefoneCelular);
        hash = 61 * hash + Objects.hashCode(this.telefoneFixo);
        hash = 61 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 61 * hash + Objects.hashCode(this.senha);
        hash = 61 * hash + Objects.hashCode(this.dataCriacao);
        hash = 61 * hash + this.contadorAcesso;
        hash = 61 * hash + Objects.hashCode(this.cargo);
        //hash = 61 * hash + Objects.hashCode(this.clinica);
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
        final Funcionarios other = (Funcionarios) obj;
        if (this.contadorAcesso != other.contadorAcesso) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCelular, other.telefoneCelular)) {
            return false;
        }
        if (!Objects.equals(this.telefoneFixo, other.telefoneFixo)) {
            return false;
        }
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        /*if (!Objects.equals(this.clinica, other.clinica)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", rg=" + rg + ", telefoneCelular=" + telefoneCelular + ", telefoneFixo=" + telefoneFixo + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + ", dataCriacao=" + dataCriacao + ", contadorAcesso=" + contadorAcesso + ", cargo=" + cargo + '}';
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getContadorAcesso() {
        return contadorAcesso;
    }

    public void setContadorAcesso(int contadorAcesso) {
        this.contadorAcesso = contadorAcesso;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Cargos getCargo() {
        return cargo;
    }
    
    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }
    
    /*public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
      */ 

}