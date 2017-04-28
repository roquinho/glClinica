
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Laudos;
import br.gl.glClinica.persistencia.InterfaceRepositorioLaudos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosLeitura;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioLaudos implements InterfaceRegraNegocioLaudos {

    @Autowired
    private InterfaceRepositorioLaudos repositorioLaudos;
    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    
    @Override
    public void gerarLaudo(Laudos laudo, Long cpfMedico, Long cpfPaciente) throws ExceptionLaudosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarLaudo(Laudos laudo) throws ExceptionLaudosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarLaudo(int codigoLaudo) throws ExceptionLaudosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Laudos> filtrarLaudoData(Date dataLaudo) throws ExceptionLaudosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Laudos filtrarLaudoCodigo(int codigoLaudo) throws ExceptionLaudosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioLaudos getRepositorioLaudos() {
        return repositorioLaudos;
    }

    public void setRepositorioLaudos(InterfaceRepositorioLaudos repositorioLaudos) {
        this.repositorioLaudos = repositorioLaudos;
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
    
}
