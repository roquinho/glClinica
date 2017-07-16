
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
public class Laudos implements Serializable {
    
    private int codigoLaudo;
    private String descricaoLaudo;
    private Date dataLaudo;
    private Date horaLaudo;
    private Date dataExame;
    private Pacientes paciente;
    private Medicos medico;
    private Exames exame;
    
    public Laudos() {
        
    }

    public Laudos(String descricaoLaudo, Date dataLaudo, Date horaLaudo,Date dataExame) {
        this.descricaoLaudo = descricaoLaudo;
        this.dataLaudo = dataLaudo;
        this.horaLaudo = horaLaudo;
        this.dataExame = dataExame;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigoLaudo;
        hash = 23 * hash + Objects.hashCode(this.descricaoLaudo);
        hash = 23 * hash + Objects.hashCode(this.dataLaudo);
        hash = 23 * hash + Objects.hashCode(this.horaLaudo);
        hash = 23 * hash + Objects.hashCode(this.dataExame);
        hash = 23 * hash + Objects.hashCode(this.paciente);
        hash = 23 * hash + Objects.hashCode(this.medico);
        hash = 23 * hash + Objects.hashCode(this.exame);
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
        final Laudos other = (Laudos) obj;
        if (this.codigoLaudo != other.codigoLaudo) {
            return false;
        }
        if (!Objects.equals(this.descricaoLaudo, other.descricaoLaudo)) {
            return false;
        }
        if (!Objects.equals(this.dataLaudo, other.dataLaudo)) {
            return false;
        }
        if (!Objects.equals(this.horaLaudo, other.horaLaudo)) {
            return false;
        }
        if (!Objects.equals(this.dataExame, other.dataExame)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.exame, other.exame)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laudos{" + "codigoLaudo=" + codigoLaudo + ", descricaoLaudo=" + descricaoLaudo + ", dataLaudo=" + dataLaudo + ", horaLaudo=" + horaLaudo + ", dataExame=" + dataExame + ", paciente=" + paciente + ", medico=" + medico + ", exame=" + exame + '}';
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoLaudo() {
        return codigoLaudo;
    }

    public void setCodigoLaudo(int codigoLaudo) {
        this.codigoLaudo = codigoLaudo;
    }

    public String getDescricaoLaudo() {
        return descricaoLaudo;
    }

    public void setDescricaoLaudo(String descricaoLaudo) {
        this.descricaoLaudo = descricaoLaudo;
    }

    @Temporal(TemporalType.DATE)
    public Date getDataLaudo() {
        return dataLaudo;
    }

    public void setDataLaudo(Date dataLaudo) {
        this.dataLaudo = dataLaudo;
    }

    @Temporal(TemporalType.TIME)
    public Date getHoraLaudo() {
        return horaLaudo;
    }

    public void setHoraLaudo(Date horaLaudo) {
        this.horaLaudo = horaLaudo;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
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
    public Exames getExame() {
        return exame;
    }

    public void setExame(Exames exame) {
        this.exame = exame;
    }
       
}

