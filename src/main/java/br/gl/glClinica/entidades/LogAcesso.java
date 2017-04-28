
package br.gl.glClinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manoel
 */
@Entity
public class LogAcesso implements Serializable {

    private int codigoAcesso;
    private Long codigoUsuario;
    private Date diaAcesso;
    private Date horaAcesso;
    
    public LogAcesso() {
        
    }

    public LogAcesso(Date diaAcesso, Date horaAcesso,Long codigoUsuario) {
        this.diaAcesso = diaAcesso;
        this.horaAcesso = horaAcesso;
        this.codigoUsuario = codigoUsuario;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigoAcesso;
        hash = 89 * hash + Objects.hashCode(this.codigoUsuario);
        hash = 89 * hash + Objects.hashCode(this.diaAcesso);
        hash = 89 * hash + Objects.hashCode(this.horaAcesso);
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
        final LogAcesso other = (LogAcesso) obj;
        if (this.codigoAcesso != other.codigoAcesso) {
            return false;
        }
        if (!Objects.equals(this.codigoUsuario, other.codigoUsuario)) {
            return false;
        }
        if (!Objects.equals(this.diaAcesso, other.diaAcesso)) {
            return false;
        }
        if (!Objects.equals(this.horaAcesso, other.horaAcesso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogAcesso{" + "codigoAcesso=" + codigoAcesso + ", codigoUsuario=" + codigoUsuario + ", diaAcesso=" + diaAcesso + ", horaAcesso=" + horaAcesso + '}';
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(int codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    @Temporal(TemporalType.DATE)
    public Date getDiaAcesso() {
        return diaAcesso;
    }

    public void setDiaAcesso(Date diaAcesso) {
        this.diaAcesso = diaAcesso;
    }
    @Temporal(TemporalType.TIME)
    public Date getHoraAcesso() {
        return horaAcesso;
    }

    public void setHoraAcesso(Date horaAcesso) {
        this.horaAcesso = horaAcesso;
    }
    
    
}
