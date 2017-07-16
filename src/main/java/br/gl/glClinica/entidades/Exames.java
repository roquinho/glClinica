
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author manoel
 */
@Entity
public class Exames implements Serializable{
    
    private int codigoExame;
    private String nomeExame;
    private String observacoesExame;
    private List<Pacientes> pacientes;
    private List<Receitas> receitas;
    private List<Laudos> laudos;
    //private List<Clinica> clinicas;
    
    public Exames() {
        
    }

    public Exames(String nomeExame, String observacoesExame) {
        this.nomeExame = nomeExame;
        this.observacoesExame = observacoesExame;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigoExame;
        hash = 47 * hash + Objects.hashCode(this.nomeExame);
        hash = 47 * hash + Objects.hashCode(this.observacoesExame);
        hash = 47 * hash + Objects.hashCode(this.pacientes);
        hash = 47 * hash + Objects.hashCode(this.receitas);
        hash = 47 * hash + Objects.hashCode(this.laudos);
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
        final Exames other = (Exames) obj;
        if (this.codigoExame != other.codigoExame) {
            return false;
        }
        if (!Objects.equals(this.nomeExame, other.nomeExame)) {
            return false;
        }
        if (!Objects.equals(this.observacoesExame, other.observacoesExame)) {
            return false;
        }
        if (!Objects.equals(this.pacientes, other.pacientes)) {
            return false;
        }
        if (!Objects.equals(this.receitas, other.receitas)) {
            return false;
        }
        if (!Objects.equals(this.laudos, other.laudos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exames{" + "codigoExame=" + codigoExame + ", nomeExame=" + nomeExame + ", observacoesExame=" + observacoesExame + ", pacientes=" + pacientes + ", receitas=" + receitas + ", laudos=" + laudos + '}';
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
 
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "exames")
    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }
    @ManyToMany(fetch = FetchType.EAGER,mappedBy="exames")
    public List<Receitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receitas> receitas) {
        this.receitas = receitas;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "exame",cascade = CascadeType.REMOVE)
    public List<Laudos> getLaudos() {
        return laudos;
    }

    public void setLaudos(List<Laudos> laudos) {
        this.laudos = laudos;
    }

   /* public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    */

    
}
