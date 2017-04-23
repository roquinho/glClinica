
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
public class Cargos implements Serializable {
   
    private int codigoCargo;
    private String descricaoCargo;
    private String nomeCargo;
    private List<Funcionarios> funcionarios;
    
       public Cargos() {
           
       }

    public Cargos(String descricaoCargo, String nomeCargo) {
        this.descricaoCargo = descricaoCargo;
        this.nomeCargo = nomeCargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigoCargo;
        hash = 79 * hash + Objects.hashCode(this.descricaoCargo);
        hash = 79 * hash + Objects.hashCode(this.nomeCargo);
        hash = 79 * hash + Objects.hashCode(this.funcionarios);
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
        final Cargos other = (Cargos) obj;
        if (this.codigoCargo != other.codigoCargo) {
            return false;
        }
        if (!Objects.equals(this.descricaoCargo, other.descricaoCargo)) {
            return false;
        }
        if (!Objects.equals(this.nomeCargo, other.nomeCargo)) {
            return false;
        }
        if (!Objects.equals(this.funcionarios, other.funcionarios)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cargos{" + "codigoCargo=" + codigoCargo + ", descricaoCargo=" + descricaoCargo + ", nomeCargo=" + nomeCargo + ", funcionarios=" + funcionarios + '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy="cargo",cascade = CascadeType.REMOVE)
    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }
       
       
}
