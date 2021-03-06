
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author manoel
 */
@Entity
public class Medicamentos implements Serializable{
    
    private int codigoMedicamento;
    private String nomeMedicamento;
    private String substanciaAtiva;
    private String posologiaIndicada;
    private String nomeLaboratorio;
    private String contraIndicacoes;
    private String generico;
    //private List<Clinica> clinicas;
    private List<Receitas> receitas;
    private List<Pacientes> pacientes;
    
    public Medicamentos() {
        
    }

    public Medicamentos(String nomeMedicamento, String substanciaAtiva, String posologiaIndicada, String nomeLaboratorio, String contraIndicacoes, String generico) {
        this.nomeMedicamento = nomeMedicamento;
        this.substanciaAtiva = substanciaAtiva;
        this.posologiaIndicada = posologiaIndicada;
        this.nomeLaboratorio = nomeLaboratorio;
        this.contraIndicacoes = contraIndicacoes;
        this.generico = generico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigoMedicamento;
        hash = 37 * hash + Objects.hashCode(this.nomeMedicamento);
        hash = 37 * hash + Objects.hashCode(this.substanciaAtiva);
        hash = 37 * hash + Objects.hashCode(this.posologiaIndicada);
        hash = 37 * hash + Objects.hashCode(this.nomeLaboratorio);
        hash = 37 * hash + Objects.hashCode(this.contraIndicacoes);
        hash = 37 * hash + Objects.hashCode(this.generico);
        hash = 37 * hash + Objects.hashCode(this.receitas);
        hash = 37 * hash + Objects.hashCode(this.pacientes);
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
        final Medicamentos other = (Medicamentos) obj;
        if (this.codigoMedicamento != other.codigoMedicamento) {
            return false;
        }
        if (!Objects.equals(this.nomeMedicamento, other.nomeMedicamento)) {
            return false;
        }
        if (!Objects.equals(this.substanciaAtiva, other.substanciaAtiva)) {
            return false;
        }
        if (!Objects.equals(this.posologiaIndicada, other.posologiaIndicada)) {
            return false;
        }
        if (!Objects.equals(this.nomeLaboratorio, other.nomeLaboratorio)) {
            return false;
        }
        if (!Objects.equals(this.contraIndicacoes, other.contraIndicacoes)) {
            return false;
        }
        if (!Objects.equals(this.generico, other.generico)) {
            return false;
        }
        if (!Objects.equals(this.receitas, other.receitas)) {
            return false;
        }
        if (!Objects.equals(this.pacientes, other.pacientes)) {
            return false;
        }
        return true;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(int codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getSubstanciaAtiva() {
        return substanciaAtiva;
    }

    public void setSubstanciaAtiva(String substanciaAtiva) {
        this.substanciaAtiva = substanciaAtiva;
    }

    public String getPosologiaIndicada() {
        return posologiaIndicada;
    }

    public void setPosologiaIndicada(String posologiaIndicada) {
        this.posologiaIndicada = posologiaIndicada;
    }

    public String getNomeLaboratorio() {
        return nomeLaboratorio;
    }

    public void setNomeLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

   /* public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }*/
    @ManyToMany(fetch = FetchType.EAGER,mappedBy="medicamentos")
    public List<Receitas> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receitas> receitas) {
        this.receitas = receitas;
    }

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "medicamentos")
    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }
    
}
