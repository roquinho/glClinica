
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.persistencia.InterfaceRepositorioConvenios;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioConvenios implements InterfaceRegraNegocioConvenios {

    @Autowired
    private InterfaceRepositorioConvenios repositorioConvenios;


    
    @Override
    public void cadastrarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
      
        if(convenio == null) {
            throw new ExceptionConveniosEscrita();
        }
        if(convenio.getNomeConvenio()==null) {
            throw new ExceptionConveniosEscrita();
        }
        if(convenio.getRegioesCobertas() == null) {
            throw new ExceptionConveniosEscrita();
        }
        else {
            this.repositorioConvenios.save(convenio);
        }
    }

    @Override
    public void atualizarConvenio(Convenios convenio) throws ExceptionConveniosEscrita {
       
        if(convenio == null) {
            throw new ExceptionConveniosEscrita();
        }
        if(convenio.getCodigoConvenio() == 0) {
            throw new ExceptionConveniosEscrita();
        }
        if(convenio.getNomeConvenio()==null) {
            throw new ExceptionConveniosEscrita();
        }
        if(convenio.getRegioesCobertas() == null) {
            throw new ExceptionConveniosEscrita();
        }
        if(this.repositorioConvenios.exists(convenio.getCodigoConvenio())==false) {
            throw new ExceptionConveniosEscrita();
        }
        else {
            Convenios novoConvenio = this.repositorioConvenios.findByCodigoConvenio(convenio.getCodigoConvenio());
               
               novoConvenio.setDataInicio(convenio.getDataInicio());
               novoConvenio.setNomeConvenio(convenio.getNomeConvenio());
               novoConvenio.setRegioesCobertas(convenio.getRegioesCobertas());
                         
                  this.repositorioConvenios.save(novoConvenio);
        } 
    }

    @Override
    public void deletarConvenio(int codigoConvenio) throws ExceptionConveniosEscrita {
        
        if(codigoConvenio == 0) {
            throw new ExceptionConveniosEscrita();
        }
        if(this.repositorioConvenios.exists(codigoConvenio)==false) {
            throw new ExceptionConveniosEscrita();
        }
        else {
            this.repositorioConvenios.delete(codigoConvenio);
        }
    }

    @Override
    public List<Convenios> listarConvenios() throws ExceptionConveniosLeitura {
        
        return this.repositorioConvenios.findAll();
    }

    @Override
    public List<Convenios> filtrarConvenioNome(String nomeConvenio) throws ExceptionConveniosLeitura {
       
        if(nomeConvenio == null) {
            throw new ExceptionConveniosLeitura();
        }
        else {
            return this.repositorioConvenios.findByNomeConvenioStartingWith(nomeConvenio);
        }
    }

    @Override
    public Convenios filtrarConvenioCodigo(int codigoConvenio) throws ExceptionConveniosLeitura {
        
        if(codigoConvenio == 0) {
            throw new ExceptionConveniosLeitura();
        }
        else {
            return this.repositorioConvenios.findByCodigoConvenio(codigoConvenio);
        }
    }

    
    
    public InterfaceRepositorioConvenios getRepositorioConvenios() {
        return repositorioConvenios;
    }

    public void setRepositorioConvenios(InterfaceRepositorioConvenios repositorioConvenios) {
        this.repositorioConvenios = repositorioConvenios;
    }
    
}
