
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class Convenios implements Serializable {
   
    private int codigoConvenio;
    private String nomeConvenio;
    private Date dataInicio;
    private String regioesCobertas;
    private List<Pacientes> pacientes;
    //private List<Clinica> clinicas;
    private List<Consultas> consultas;
    
      public Convenios() {
          
      }

    public Convenios(String nomeConvenio, Date dataInicio, String regioesCobertas) {
        this.nomeConvenio = nomeConvenio;
        this.dataInicio = dataInicio;
        this.regioesCobertas = regioesCobertas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigoConvenio;
        hash = 79 * hash + Objects.hashCode(this.nomeConvenio);
        hash = 79 * hash + Objects.hashCode(this.dataInicio);
        hash = 79 * hash + Objects.hashCode(this.regioesCobertas);
        hash = 79 * hash + Objects.hashCode(this.pacientes);
        //hash = 79 * hash + Objects.hashCode(this.clinicas);
        hash = 79 * hash + Objects.hashCode(this.consultas);
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
        final Convenios other = (Convenios) obj;
        if (this.codigoConvenio != other.codigoConvenio) {
            return false;
        }
        if (!Objects.equals(this.nomeConvenio, other.nomeConvenio)) {
            return false;
        }
        if (!Objects.equals(this.regioesCobertas, other.regioesCobertas)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.pacientes, other.pacientes)) {
            return false;
        }
       /* if (!Objects.equals(this.clinicas, other.clinicas)) {
            return false;
        }*/
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Convenios{" + "codigoConvenio=" + codigoConvenio + ", nomeConvenio=" + nomeConvenio + ", dataInicio=" + dataInicio + ", regioesCobertas=" + regioesCobertas + ", pacientes=" + pacientes + ", consultas=" + consultas + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(int codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getRegioesCobertas() {
        return regioesCobertas;
    }

    public void setRegioesCobertas(String regioesCobertas) {
        this.regioesCobertas = regioesCobertas;
    }

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "convenios",cascade = CascadeType.REMOVE)
    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy="convenio",cascade = CascadeType.REMOVE)
    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }

  /*  public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    */  
      
}
