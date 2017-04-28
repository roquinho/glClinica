
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.persistencia.InterfaceRepositorioClinica;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioClinica implements InterfaceRegraNegocioClinica {

    @Autowired
    private InterfaceRepositorioClinica repositorioClinica;
    
    @Override
    public void cadastrarClinica(Clinica clinica) throws ExceptionClinicaEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarClinica(Clinica clinica) throws ExceptionClinicaEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarClinica(Long cnpj) throws ExceptionClinicaEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clinica> listarClinicas() throws ExceptionClinicaLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clinica> filtrarClinicaNome(String nome) throws ExceptionClinicaLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clinica filtrarClinicaCnpj(Long cnpj) throws ExceptionClinicaLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioClinica getRepositorioClinica() {
        return repositorioClinica;
    }

    public void setRepositorioClinica(InterfaceRepositorioClinica repositorioClinica) {
        this.repositorioClinica = repositorioClinica;
    }
    
}
