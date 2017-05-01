
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
        
        if(laudo == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(cpfMedico == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(cpfMedico<=0) {
            throw new ExceptionLaudosEscrita();
        }
        if(cpfPaciente == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(cpfPaciente<=0) {
            throw new ExceptionLaudosEscrita();
        }
        else {
            laudo.setMedico(this.repositorioMedicos.findByCpf(cpfMedico));
            laudo.setPaciente(this.repositorioPacientes.findByCpf(cpfPaciente));
            
        }
        if(laudo.getMedico() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getPaciente() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getDataLaudo() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getDescricaoLaudo() == null) {
            throw new ExceptionLaudosEscrita();
        }
        else {
            this.repositorioLaudos.save(laudo);
        }
    }

    @Override
    public void atualizarLaudo(Laudos laudo) throws ExceptionLaudosEscrita {
       
        if(laudo == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getCodigoLaudo()<=0) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getMedico() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getPaciente() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getDataLaudo() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(laudo.getDescricaoLaudo() == null) {
            throw new ExceptionLaudosEscrita();
        }
        if(this.repositorioLaudos.exists(laudo.getCodigoLaudo())== false) {
            throw new ExceptionLaudosEscrita();
        }
        else {
            Laudos novoLaudo = this.repositorioLaudos.findByCodigoLaudo(laudo.getCodigoLaudo());
            
               novoLaudo.setDescricaoLaudo(laudo.getDescricaoLaudo());
                
                  this.repositorioLaudos.save(novoLaudo);
        }
 
    }

    @Override
    public void deletarLaudo(int codigoLaudo) throws ExceptionLaudosEscrita {
        
        if(codigoLaudo <= 0) {
            throw new ExceptionLaudosEscrita();
        }
        if(this.repositorioLaudos.exists(codigoLaudo)==false ){
            throw new ExceptionLaudosEscrita();
        }
        else {
            this.repositorioLaudos.delete(codigoLaudo);
        }
    }

    @Override
    public List<Laudos> filtrarLaudoData(Date dataLaudo) throws ExceptionLaudosLeitura {
        
        if(dataLaudo == null) {
            throw new ExceptionLaudosLeitura();
        }
        else {
            return this.repositorioLaudos.findByDataLaudo(dataLaudo);
        }
    }

    @Override
    public Laudos filtrarLaudoCodigo(int codigoLaudo) throws ExceptionLaudosLeitura {
        
        if(codigoLaudo <= 0) {
            throw new ExceptionLaudosLeitura();
        }
        else {
            return this.filtrarLaudoCodigo(codigoLaudo);
        }
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
