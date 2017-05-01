
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionConsultasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desmarcarConsulta(int codigoConsulta) throws ExceptionConsultasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultas> listarConsultas() throws ExceptionConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultas> filtrarConsultaDataConsulta(Date dataConsulta) throws ExceptionConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultas filtrarConsultaCodigo(int codigoConsulta) throws ExceptionConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultas filtrarConsultaDataAndHoraConsulta(Date dataConsulta, Date horaConsulta) throws ExceptionConsultasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
