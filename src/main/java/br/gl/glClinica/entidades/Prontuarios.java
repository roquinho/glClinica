
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
public class Prontuarios implements Serializable {
   
    private int codigoProntuario;    
    private String observacoes;   
    private Date dataInicioTratamento;
    private Date dataFimTratamento;
    private Pacientes paciente;
    
    public Prontuarios() {
        
    }

    public Prontuarios(String observacoes,Date dataInicioTratamento, Date dataFimTratamento) {        
        this.observacoes = observacoes;
        this.dataInicioTratamento = dataInicioTratamento;
        this.dataFimTratamento = dataFimTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.codigoProntuario;
        hash = 19 * hash + Objects.hashCode(this.observacoes);
        hash = 19 * hash + Objects.hashCode(this.dataInicioTratamento);
        hash = 19 * hash + Objects.hashCode(this.dataFimTratamento);
        hash = 19 * hash + Objects.hashCode(this.paciente);
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
        final Prontuarios other = (Prontuarios) obj;
        if (this.codigoProntuario != other.codigoProntuario) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioTratamento, other.dataInicioTratamento)) {
            return false;
        }
        if (!Objects.equals(this.dataFimTratamento, other.dataFimTratamento)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prontuarios{" + "codigoProntuario=" + codigoProntuario + ", observacoes=" + observacoes + ", dataInicioTratamento=" + dataInicioTratamento + ", dataFimTratamento=" + dataFimTratamento + ", paciente=" + paciente + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoProntuario() {
        return codigoProntuario;
    }

    public void setCodigoProntuario(int codigoProntuario) {
        this.codigoProntuario = codigoProntuario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    @Temporal(TemporalType.DATE)
    public Date getDataInicioTratamento() {
        return dataInicioTratamento;
    }

    public void setDataInicioTratamento(Date dataInicioTratamento) {
        this.dataInicioTratamento = dataInicioTratamento;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataFimTratamento() {
        return dataFimTratamento;
    }

    public void setDataFimTratamento(Date dataFimTratamento) {
        this.dataFimTratamento = dataFimTratamento;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    
}
