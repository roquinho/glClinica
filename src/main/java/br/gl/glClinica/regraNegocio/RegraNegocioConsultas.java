
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Consultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioConsultas;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioTiposConsultas;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasLeitura;
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
    public List<Consultas> listarConsultas() throws ExceptionConsultasLeitura {
        
        return this.repositorioConsultas.findAll();
    }

    @Override
    public List<Consultas> filtrarConsultaDataConsulta(Date dataConsulta) throws ExceptionConsultasLeitura {
       
        if(dataConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }
        else {
            return this.repositorioConsultas.findByDataConsultaStartingWithOrderByDataConsulta(dataConsulta);
        }
    }

    @Override
    public Consultas filtrarConsultaCodigo(int codigoConsulta) throws ExceptionConsultasLeitura {
        
        if(codigoConsulta<=0) {
            throw new ExceptionConsultasLeitura();
        }
        else {
            return this.repositorioConsultas.findByCodigoConsulta(codigoConsulta);
        }
    }

    @Override
    public Consultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta) throws ExceptionConsultasLeitura {
        
        if(dataConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }  
        if(horaConsulta == null) {
            throw new ExceptionConsultasLeitura();
        }
        else {
            return this.repositorioConsultas.findByDataConsultaAndHoraConsultaStartingWithOrderByDataConsulta(dataConsulta, horaConsulta);
        }
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
