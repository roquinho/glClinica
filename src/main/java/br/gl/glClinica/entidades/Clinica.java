
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author manoel
 */
@Entity
public class Clinica implements Serializable {
    
    private String cnpj;
    private String nome;
    private String especialidades;
    private String endereco;
    private String telefone;
    private String email;
   /* private List<Pacientes> pacientes;
    private List<Medicos> medicos;
    private List<Convenios> convenios;
    private List<Medicamentos> medicamentos;
    private List<TiposConsultas> tiposConsulta;
    private List<Funcionarios> funcionarios;
    private List<Exames> exames;
    */
    public Clinica() {
        
    }

    public Clinica(String cnpj, String nome, String especialidades, String endereco, String telefone, String email) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.especialidades = especialidades;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cnpj);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.especialidades);
        hash = 71 * hash + Objects.hashCode(this.endereco);
        hash = 71 * hash + Objects.hashCode(this.telefone);
        /*hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.pacientes);
        hash = 71 * hash + Objects.hashCode(this.medicos);
        hash = 71 * hash + Objects.hashCode(this.convenios);
        hash = 71 * hash + Objects.hashCode(this.medicamentos);
        hash = 71 * hash + Objects.hashCode(this.tiposConsulta);
        hash = 71 * hash + Objects.hashCode(this.funcionarios);
        hash = 71 * hash + Objects.hashCode(this.exames);*/
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
        final Clinica other = (Clinica) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.especialidades, other.especialidades)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        /*if (!Objects.equals(this.pacientes, other.pacientes)) {
            return false;
        }
        if (!Objects.equals(this.medicos, other.medicos)) {
            return false;
        }
        if (!Objects.equals(this.convenios, other.convenios)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.tiposConsulta, other.tiposConsulta)) {
            return false;
        }
        if (!Objects.equals(this.funcionarios, other.funcionarios)) {
            return false;
        }
        if (!Objects.equals(this.exames, other.exames)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Clinica{" + "cnpj=" + cnpj + ", nome=" + nome + ", especialidades=" + especialidades + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + '}';
    }

    @Id
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  /*  public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Medicos> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medicos> medicos) {
        this.medicos = medicos;
    }

    public List<Convenios> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenios> convenios) {
        this.convenios = convenios;
    }

    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<TiposConsultas> getTiposConsulta() {
        return tiposConsulta;
    }

    public void setTiposConsulta(List<TiposConsultas> tiposConsulta) {
        this.tiposConsulta = tiposConsulta;
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Exames> getExames() {
        return exames;
    }

    public void setExames(List<Exames> exames) {
        this.exames = exames;
    }*/
    
}
