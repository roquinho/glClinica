
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Consultas;
import br.gl.glClinica.listarEntidades.ListarConsultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioConsultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioTiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasLeitura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioConsultas implements InterfaceRegraNegocioConsultas {

    @Autowired
    private InterfaceRepositorioConsultas repositorioConsultas;
    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    @Autowired
    private InterfaceRepositorioTiposConsultas repositorioTiposConsultas;
    
    
    
    @Override
    public void marcarConsulta(Consultas consulta, Long cpfMedico, Long cpfPaciente, int tipoConsulta) throws ExceptionConsultasEscrita {
        
        if(consulta == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(cpfMedico == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(cpfMedico<=0) {
            throw new ExceptionConsultasEscrita();
        }
        if(cpfPaciente == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(cpfPaciente<=0) {
            throw new ExceptionConsultasEscrita();
        }
        if(tipoConsulta<=0) {
            throw new ExceptionConsultasEscrita();
        }
        else {
            consulta.setMedico(this.repositorioMedicos.findByCpf(cpfMedico));
            consulta.setPaciente(this.repositorioPacientes.findByCpf(cpfPaciente));
            consulta.setTipoConsulta(this.repositorioTiposConsultas.findByCodigoTipoConsulta(tipoConsulta));
            
        }
        if(consulta.getMedico() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getPaciente() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getTipoConsulta() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getDataConsulta() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getHoraConsulta() == null) {
            throw new ExceptionConsultasEscrita();
        }
        
        else {
            this.repositorioConsultas.save(consulta);
        }
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionConsultasEscrita {
        
        if(consulta == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getCodigoConsulta()<=0) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getDataConsulta() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(consulta.getHoraConsulta() == null) {
            throw new ExceptionConsultasEscrita();
        }
        if(this.repositorioConsultas.exists(consulta.getCodigoConsulta()) == false) {
            throw new ExceptionConsultasEscrita();
        }
        else  {
            Consultas novaConsulta = this.repositorioConsultas.findByCodigoConsulta(consulta.getCodigoConsulta());
            
              novaConsulta.setDataConsulta(consulta.getDataConsulta());
              novaConsulta.setHoraConsulta(consulta.getHoraConsulta());
              
                 this.repositorioConsultas.save(novaConsulta);
        }

    }

    @Override
    public void desmarcarConsulta(int codigoConsulta) throws ExceptionConsultasEscrita {
        
        if(codigoConsulta<=0) {
            throw new ExceptionConsultasEscrita();
        }
        if(this.repositorioConsultas.exists(codigoConsulta)==false) {
            throw new ExceptionConsultasEscrita();
        }
        else {
            this.repositorioConsultas.delete(codigoConsulta);
        }
    }

    @Override
    public List<ListarConsultas> listarConsultas() throws ExceptionConsultasLeitura {
        List<ListarConsultas> listaListaConsultas = null;       
         List<Consultas> listaConsultasBD = this.repositorioConsultas.findAll();
          if(listaConsultasBD!=null) {
              listaListaConsultas = new ArrayList<>();
                for(int i=0; i<listaConsultasBD.size();i++) {
                    ListarConsultas listaConsultas = new ListarConsultas(listaConsultasBD.get(i));
                      listaListaConsultas.add(listaConsultas);
                }
          }
          return listaListaConsultas;
    }

    @Override
    public List<ListarConsultas> filtrarConsultaDataConsulta(Date dataConsulta) throws ExceptionConsultasLeitura {
       List<ListarConsultas> listaListarConsultas = null;
        if(dataConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }
        else {
              List<Consultas> listaConsultasesBD = this.repositorioConsultas.findByDataConsultaStartingWithOrderByDataConsulta(dataConsulta);
        if(listaConsultasesBD!=null) {
                 listaListarConsultas = new ArrayList<>();
                   for(int i=0; i<listaConsultasesBD.size(); i++) {
                    ListarConsultas listaConsultas =  new ListarConsultas(listaConsultasesBD.get(i));
                      listaListarConsultas.add(listaConsultas);
               }
                }
        }
        return listaListarConsultas;
    }

    @Override
    public ListarConsultas filtrarConsultaCodigo(int codigoConsulta) throws ExceptionConsultasLeitura {
      ListarConsultas listaConsultas = null;  
        if(codigoConsulta<=0) {
            throw new ExceptionConsultasLeitura();
        }
        else {
            Consultas Consultas = this.repositorioConsultas.findByCodigoConsulta(codigoConsulta);
        if(Consultas!=null) {
              listaConsultas = new ListarConsultas(Consultas);
        }    
        }
        return listaConsultas;
    }

    @Override
    public ListarConsultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta) throws ExceptionConsultasLeitura {
      ListarConsultas listaConsultas = null;
      
        if(dataConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }  
        if(horaConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }
        else {
            Consultas consulta = this.repositorioConsultas.findByDataConsultaAndHoraConsultaStartingWithOrderByDataConsulta(dataConsulta, horaConsulta);
        if(consulta!=null) {
              listaConsultas = new ListarConsultas(consulta);
        }      
        }
        return listaConsultas;
    }

    
    public InterfaceRepositorioConsultas getRepositorioConsultas() {
        return repositorioConsultas;
    }

    public void setRepositorioConsultas(InterfaceRepositorioConsultas repositorioConsultas) {
        this.repositorioConsultas = repositorioConsultas;
    }

    public InterfaceRepositorioPacientes getRepositorioPacientes() {
        return repositorioPacientes;
    }

    public void setRepositorioPacientes(InterfaceRepositorioPacientes repositorioPacientes) {
        this.repositorioPacientes = repositorioPacientes;
    }

    public InterfaceRepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public void setRepositorioMedicos(InterfaceRepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }

    public InterfaceRepositorioTiposConsultas getRepositorioTiposConsultas() {
        return repositorioTiposConsultas;
    }

    public void setRepositorioTiposConsultas(InterfaceRepositorioTiposConsultas repositorioTiposConsultas) {
        this.repositorioTiposConsultas = repositorioTiposConsultas;
    }
    
}
