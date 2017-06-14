
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.listarEntidades.ListarTiposConsultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioTiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioTiposConsultas implements InterfaceRegraNegocioTiposConsultas {

    @Autowired
    private InterfaceRepositorioTiposConsultas repositorioTiposConsultas;


    
    @Override
    public void cadastrarTipoConsulta(TiposConsultas tipoConsulta) throws ExceptionTiposConsultasEscrita {
       
        if(tipoConsulta == null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tipoConsulta.getNomeTipoConsulta()== null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tipoConsulta.getValorTipoConsulta() <0) {
           throw new ExceptionTiposConsultasEscrita();
        }
        else {
            this.repositorioTiposConsultas.save(tipoConsulta);
        }
    }
    

    @Override
    public void atualizarTipoConsulta(TiposConsultas tiposConsulta) throws ExceptionTiposConsultasEscrita {
                
        if(tiposConsulta == null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getCodigoTipoConsulta() <= 0) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getNomeTipoConsulta()== null) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(tiposConsulta.getValorTipoConsulta() <0) {
           throw new ExceptionTiposConsultasEscrita();
        }
        if(this.repositorioTiposConsultas.exists(tiposConsulta.getCodigoTipoConsulta())==false) {
            throw new ExceptionTiposConsultasEscrita();
        }
        else {
            TiposConsultas novoTiposConsultas = this.repositorioTiposConsultas.findByCodigoTipoConsulta(tiposConsulta.getCodigoTipoConsulta());
              
               novoTiposConsultas.setNomeTipoConsulta(tiposConsulta.getNomeTipoConsulta());
               novoTiposConsultas.setValorTipoConsulta(tiposConsulta.getValorTipoConsulta());
               
                  this.repositorioTiposConsultas.save(novoTiposConsultas);
        }      
    }

    @Override
    public void deletarTipoConsulta(int codigoTipoConsulta) throws ExceptionTiposConsultasEscrita {
       
        if(codigoTipoConsulta <= 0) {
            throw new ExceptionTiposConsultasEscrita();
        }
        if(this.repositorioTiposConsultas.exists(codigoTipoConsulta)==false){
            throw new ExceptionTiposConsultasEscrita();
        }
        else {
            this.repositorioTiposConsultas.delete(codigoTipoConsulta);
        }
    }

    @Override
    public List<ListarTiposConsultas> listarTiposConsulta() throws ExceptionTiposConsultasLeitura {
      List<ListarTiposConsultas> listaListarTiposConsultas = null;        
        List<TiposConsultas> listaTiposConsultasBD = this.repositorioTiposConsultas.findAll();
          if(listaTiposConsultasBD!=null) {
              listaListarTiposConsultas = new ArrayList<>();
                for(int i=0; i<listaTiposConsultasBD.size(); i++) {
                    ListarTiposConsultas listaTiposConsultas = new ListarTiposConsultas(listaTiposConsultasBD.get(i));
                     listaListarTiposConsultas.add(listaTiposConsultas);
                }
          } 
          return listaListarTiposConsultas;
    }

    @Override
    public List<ListarTiposConsultas> filtrarTipoConsultaNome(String nome) throws ExceptionTiposConsultasLeitura {
     List<ListarTiposConsultas> listaListarTiposConsultas = null;
     
        if(nome == null) {
            throw new ExceptionTiposConsultasLeitura();
        }
        else {
          List<TiposConsultas> listaTiposConsultasBD = this.repositorioTiposConsultas.findByNomeTipoConsultaStartingWith(nome);
        if(listaTiposConsultasBD!=null) {
            listaListarTiposConsultas = new ArrayList<>();
             for(int i=0; i<listaTiposConsultasBD.size();i++) {
               ListarTiposConsultas listaConsultas = new ListarTiposConsultas(listaTiposConsultasBD.get(i));
                 listaListarTiposConsultas.add(listaConsultas);
             }
        }   
          
        }
        return listaListarTiposConsultas;
    }

    @Override
    public ListarTiposConsultas filtrarTipoConsultaCodigo(int codigoTipoConsulta) throws ExceptionTiposConsultasLeitura {
     ListarTiposConsultas listaTiposConsultas = null;
     
        if(codigoTipoConsulta <= 0) {
            throw new ExceptionTiposConsultasLeitura();
        }
        else {
           TiposConsultas tipoConsultas = this.repositorioTiposConsultas.findByCodigoTipoConsulta(codigoTipoConsulta);
        if(tipoConsultas!=null) {
             listaTiposConsultas = new ListarTiposConsultas(tipoConsultas);
        }    
        }
        return listaTiposConsultas;
    }

    
    
    public InterfaceRepositorioTiposConsultas getRepositorioTiposConsultas() {
        return repositorioTiposConsultas;
    }

    public void setRepositorioTiposConsultas(InterfaceRepositorioTiposConsultas repositorioTiposConsultas) {
        this.repositorioTiposConsultas = repositorioTiposConsultas;
    }
    
}
