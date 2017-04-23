
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
import javax.persistence.OneToMany;

/**
 *
 * @author manoel
 */
@Entity
public class TiposConsultas implements Serializable{
   
    private int codigoTipoConsulta;
    private String nomeTipoConsulta;
    private double valorTipoConsulta;
    private List<Consultas> consultas;
    //private List<Clinica> clinicas;

    public TiposConsultas() {
        
    }
    
    public TiposConsultas(String nomeTipoConsulta, double valorTipoConsulta) {
        this.nomeTipoConsulta = nomeTipoConsulta;
        this.valorTipoConsulta = valorTipoConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigoTipoConsulta;
        hash = 59 * hash + Objects.hashCode(this.nomeTipoConsulta);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorTipoConsulta) ^ (Double.doubleToLongBits(this.valorTipoConsulta) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.consultas);
        //hash = 59 * hash + Objects.hashCode(this.clinicas);
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
        final TiposConsultas other = (TiposConsultas) obj;
        if (this.codigoTipoConsulta != other.codigoTipoConsulta) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTipoConsulta) != Double.doubleToLongBits(other.valorTipoConsulta)) {
            return false;
        }
        if (!Objects.equals(this.nomeTipoConsulta, other.nomeTipoConsulta)) {
            return false;
        }
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        /*if (!Objects.equals(this.clinicas, other.clinicas)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "TiposConsultas{" + "codigoTipoConsulta=" + codigoTipoConsulta + ", nomeTipoConsulta=" + nomeTipoConsulta + ", valorTipoConsulta=" + valorTipoConsulta + ", consultas=" + consultas + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoTipoConsulta() {
        return codigoTipoConsulta;
    }

    public void setCodigoTipoConsulta(int codigoTipoConsulta) {
        this.codigoTipoConsulta = codigoTipoConsulta;
    }

    public String getNomeTipoConsulta() {
        return nomeTipoConsulta;
    }

    public void setNomeTipoConsulta(String nomeTipoConsulta) {
        this.nomeTipoConsulta = nomeTipoConsulta;
    }

    public double getValorTipoConsulta() {
        return valorTipoConsulta;
    }

    public void setValorTipoConsulta(double valorTipoConsulta) {
        this.valorTipoConsulta = valorTipoConsulta;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy="tipoConsulta",cascade = CascadeType.REMOVE)
    public List<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consultas> consultas) {
        this.consultas = consultas;
    }

    /*public List<Clinica> getClinicas() {
        return clinicas;
    }

    public void setClinicas(List<Clinica> clinicas) {
        this.clinicas = clinicas;
    }
    */
    
    
}
