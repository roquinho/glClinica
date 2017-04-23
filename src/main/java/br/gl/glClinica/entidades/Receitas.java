
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class Receitas implements Serializable {
    
    private int codigoReceita;
    private Date dataReceita;
    private List<Medicamentos> medicamentos;
    private Pacientes paciente;
    private List<Exames> exames;
    private Medicos medico;
    
    public Receitas() {
        
    }

    public Receitas(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigoReceita;
        hash = 47 * hash + Objects.hashCode(this.dataReceita);
        hash = 47 * hash + Objects.hashCode(this.medicamentos);
        hash = 47 * hash + Objects.hashCode(this.paciente);
        hash = 47 * hash + Objects.hashCode(this.exames);
        hash = 47 * hash + Objects.hashCode(this.medico);
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
        final Receitas other = (Receitas) obj;
        if (this.codigoReceita != other.codigoReceita) {
            return false;
        }
        if (!Objects.equals(this.dataReceita, other.dataReceita)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.exames, other.exames)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Receitas{" + "codigoReceita=" + codigoReceita + ", dataReceita=" + dataReceita + ", medicamentos=" + medicamentos + ", paciente=" + paciente + ", exames=" + exames + ", medico=" + medico + '}';
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoReceita() {
        return codigoReceita;
    }

    public void setCodigoReceita(int codigoReceita) {
        this.codigoReceita = codigoReceita;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }
     
    @ManyToMany
    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
    @ManyToMany
    public List<Exames> getExames() {
        return exames;
    }

    public void setExames(List<Exames> exames) {
        this.exames = exames;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }


}
