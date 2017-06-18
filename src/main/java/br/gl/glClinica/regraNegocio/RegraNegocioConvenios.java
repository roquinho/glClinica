
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.listarEntidades.ListarConvenios;
import br.gl.glClinica.persistencia.InterfaceRepositorioConvenios;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
import java.util.ArrayList;
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
        if(convenio.getCodigoConvenio() <= 0) {
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
        
        if(codigoConvenio <= 0) {
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
    public List<ListarConvenios> listarConvenios() throws ExceptionConveniosLeitura {
      List<ListarConvenios> listaListarConvenios = null;  
        List<Convenios> listaConveniosBD = this.repositorioConvenios.findAll();
         if(listaConveniosBD != null) {
             listaListarConvenios = new ArrayList<>();
               for(int i=0; i<listaConveniosBD.size(); i++) {
                   ListarConvenios listaConvenios = new ListarConvenios(listaConveniosBD.get(i));
                     listaListarConvenios.add(listaConvenios);
               }
         }
         return listaListarConvenios;
    }

    @Override
    public List<ListarConvenios> filtrarConvenioNome(String nomeConvenio) throws ExceptionConveniosLeitura {
      List<ListarConvenios> listaListarConvenios = null; 
        
        if(nomeConvenio == null) {
            throw new ExceptionConveniosLeitura();
        }
        else {
            List<Convenios> listaConveniosBD = this.repositorioConvenios.findByNomeConvenioStartingWith(nomeConvenio);
        if(listaConveniosBD!=null) {
              listaListarConvenios = new ArrayList<>();
                for(int i=0; i<listaConveniosBD.size(); i++) {
                   ListarConvenios listarConvenios = new ListarConvenios(listaConveniosBD.get(i));
                     listaListarConvenios.add(listarConvenios);
                }
        }
        }
        return listaListarConvenios;
    }

    @Override
    public ListarConvenios filtrarConvenioCodigo(int codigoConvenio) throws ExceptionConveniosLeitura {
      ListarConvenios listaConvenios = null;  
        if(codigoConvenio <= 0) {
            throw new ExceptionConveniosLeitura();
        }
        else {
            Convenios convenio = this.repositorioConvenios.findByCodigoConvenio(codigoConvenio);
        if(convenio!=null) {
              listaConvenios = new ListarConvenios(convenio);
        }    
        }
        return listaConvenios;
    }

    
    
    public InterfaceRepositorioConvenios getRepositorioConvenios() {
        return repositorioConvenios;
    }

    public void setRepositorioConvenios(InterfaceRepositorioConvenios repositorioConvenios) {
        this.repositorioConvenios = repositorioConvenios;
    }
    
}
