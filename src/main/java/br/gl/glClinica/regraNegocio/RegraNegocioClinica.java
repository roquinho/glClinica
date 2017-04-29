
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.persistencia.InterfaceRepositorioClinica;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
        if(clinica == null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getCnpj()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getCnpj() == 0) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getEndereco()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getNome()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(this.repositorioClinica.exists(clinica.getCnpj())==true) {
            throw new ExceptionClinicaEscrita();
        }
        else {
            this.repositorioClinica.save(clinica);
        }
    }

    @Override
    public void atualizarClinica(Clinica clinica) throws ExceptionClinicaEscrita {
       
        if(clinica == null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getCnpj()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getCnpj() == 0) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getEndereco()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(clinica.getNome()==null) {
            throw new ExceptionClinicaEscrita();
        }
        if(this.repositorioClinica.exists(clinica.getCnpj())==false) {
            throw new ExceptionClinicaEscrita();
        }
        else {
          Clinica novaClinica = this.repositorioClinica.findByCnpj(clinica.getCnpj());
            
               novaClinica.setEmail(clinica.getEmail());
               novaClinica.setEndereco(clinica.getEndereco());
               novaClinica.setEspecialidades(clinica.getEspecialidades());
               novaClinica.setNome(clinica.getNome());
               novaClinica.setTelefone(clinica.getTelefone());
               
                    this.repositorioClinica.save(novaClinica);
        }
    }

    @Override
    public void deletarClinica(Long cnpj) throws ExceptionClinicaEscrita {
        
        if(cnpj == null) {
            throw new ExceptionClinicaEscrita();
        }       
        if(cnpj == 0) {
            throw new ExceptionClinicaEscrita();
        }
        if(this.repositorioClinica.exists(cnpj)==false) {
            throw new ExceptionClinicaEscrita();
        }
        else {
            this.repositorioClinica.delete(cnpj);
        }
    }

    @Override
    public List<Clinica> listarClinicas() throws ExceptionClinicaLeitura {
        
        return this.repositorioClinica.findAll();
    }

    @Override
    public List<Clinica> filtrarClinicaNome(String nome) throws ExceptionClinicaLeitura {
        
        if(nome == null) {
            throw new ExceptionClinicaLeitura();
        }
        else {
           return this.repositorioClinica.findByNomeStartingWith(nome);
        }
    }

    @Override
    public Clinica filtrarClinicaCnpj(Long cnpj) throws ExceptionClinicaLeitura {
        
        if(cnpj == null) {
            throw new ExceptionClinicaLeitura();
        }
        if(cnpj == 0) {
            throw new ExceptionClinicaLeitura();
        }
        else {
            return this.repositorioClinica.findByCnpj(cnpj);
        }
    }

    public InterfaceRepositorioClinica getRepositorioClinica() {
        return repositorioClinica;
    }

    public void setRepositorioClinica(InterfaceRepositorioClinica repositorioClinica) {
        this.repositorioClinica = repositorioClinica;
    }
    
}
