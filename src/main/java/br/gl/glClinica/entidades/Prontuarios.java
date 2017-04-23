
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
    private String posologiaReceitada;
    private String observacoes;
    private String resultadoExame;
    private Date dataExame;
    private Date dataInicioTratamento;
    private Date dataFimTratamento;
    private Exames exame;
    private Pacientes paciente;
    private Medicamentos medicamento;
    
    public Prontuarios() {
        
    }

    public Prontuarios(String posologiaReceitada, String observacoes, String resultadoExame, Date dataExame, Date dataInicioTratamento, Date dataFimTratamento) {
        this.posologiaReceitada = posologiaReceitada;
        this.observacoes = observacoes;
        this.resultadoExame = resultadoExame;
        this.dataExame = dataExame;
        this.dataInicioTratamento = dataInicioTratamento;
        this.dataFimTratamento = dataFimTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigoProntuario;
        hash = 53 * hash + Objects.hashCode(this.posologiaReceitada);
        hash = 53 * hash + Objects.hashCode(this.observacoes);
        hash = 53 * hash + Objects.hashCode(this.resultadoExame);
        hash = 53 * hash + Objects.hashCode(this.dataExame);
        hash = 53 * hash + Objects.hashCode(this.dataInicioTratamento);
        hash = 53 * hash + Objects.hashCode(this.dataFimTratamento);
        hash = 53 * hash + Objects.hashCode(this.exame);
        hash = 53 * hash + Objects.hashCode(this.paciente);
        hash = 53 * hash + Objects.hashCode(this.medicamento);
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
        if (!Objects.equals(this.posologiaReceitada, other.posologiaReceitada)) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.resultadoExame, other.resultadoExame)) {
            return false;
        }
        if (!Objects.equals(this.dataExame, other.dataExame)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioTratamento, other.dataInicioTratamento)) {
            return false;
        }
        if (!Objects.equals(this.dataFimTratamento, other.dataFimTratamento)) {
            return false;
        }
        if (!Objects.equals(this.exame, other.exame)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.medicamento, other.medicamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prontuarios{" + "codigoProntuario=" + codigoProntuario + ", posologiaReceitada=" + posologiaReceitada + ", observacoes=" + observacoes + ", resultadoExame=" + resultadoExame + ", dataExame=" + dataExame + ", dataInicioTratamento=" + dataInicioTratamento + ", dataFimTratamento=" + dataFimTratamento + ", exame=" + exame + ", paciente=" + paciente + ", medicamento=" + medicamento + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoProntuario() {
        return codigoProntuario;
    }

    public void setCodigoProntuario(int codigoProntuario) {
        this.codigoProntuario = codigoProntuario;
    }

    public String getPosologiaReceitada() {
        return posologiaReceitada;
    }

    public void setPosologiaReceitada(String posologiaReceitada) {
        this.posologiaReceitada = posologiaReceitada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    @Temporal(TemporalType.DATE) 
    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
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
    public Exames getExame() {
        return exame;
    }

    public void setExame(Exames exame) {
        this.exame = exame;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Medicamentos getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamentos medicamento) {
        this.medicamento = medicamento;
    }
    
}
