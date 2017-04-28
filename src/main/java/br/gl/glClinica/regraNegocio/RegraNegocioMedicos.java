
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioMedicos implements InterfaceRegraNegocioMedicos {

    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    
    @Override
    public void cadastrarMedico(Medicos medico) throws ExceptionMedicosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionMedicosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarMedico(Long cpf) throws ExceptionMedicosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicos> listarMedicos() throws ExceptionMedicosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicos> filtrarMedicoNome(String nome) throws ExceptionMedicosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicos> filtrarMedicoEspecialidade(String especialidade) throws ExceptionMedicosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicos filtrarMedicoCpf(Long cpf) throws ExceptionMedicosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicos filtrarMedicoUsuarioSenha(String usuario, String senha) throws ExceptionMedicosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public void setRepositorioMedicos(InterfaceRepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }
    
}
