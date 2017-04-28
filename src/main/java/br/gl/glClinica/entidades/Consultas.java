
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class Consultas implements Serializable {
   
    private int codigoConsulta;
    private Date dataConsulta;
    private Date horaConsulta;
    private Pacientes paciente;
    private Medicos medico;
    private TiposConsultas tipoConsulta;
    
    public Consultas() {
        
    }

    public Consultas(Date dataConsulta, Date horaConsulta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigoConsulta;
        hash = 29 * hash + Objects.hashCode(this.dataConsulta);
        hash = 29 * hash + Objects.hashCode(this.horaConsulta);
        hash = 29 * hash + Objects.hashCode(this.paciente);
        hash = 29 * hash + Objects.hashCode(this.medico);
        hash = 29 * hash + Objects.hashCode(this.tipoConsulta);
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
        final Consultas other = (Consultas) obj;
        if (this.codigoConsulta != other.codigoConsulta) {
            return false;
        }
        if (!Objects.equals(this.dataConsulta, other.dataConsulta)) {
            return false;
        }
        if (!Objects.equals(this.horaConsulta, other.horaConsulta)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.tipoConsulta, other.tipoConsulta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultas{" + "codigoConsulta=" + codigoConsulta + ", dataConsulta=" + dataConsulta + ", horaConsulta=" + horaConsulta + ", paciente=" + paciente + ", medico=" + medico + ", tipoConsulta=" + tipoConsulta + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Temporal(TemporalType.TIME)
    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
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
    @ManyToOne(fetch = FetchType.EAGER)
    public TiposConsultas getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TiposConsultas tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    
}
