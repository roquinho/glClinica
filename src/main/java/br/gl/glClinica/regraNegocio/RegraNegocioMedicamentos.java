
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioMedicamentos implements InterfaceRegraNegocioMedicamentos {

    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
    
    @Override
    public void cadastrarMedicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarMedcicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarMedicamento(int codigoMedicamento) throws ExceptionMedicamentosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicamentos> listarMedicamentos() throws ExceptionMedicamentosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicamentos> filtrarMedicamentoNome(String nomeMedicamento) throws ExceptionMedicamentosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio) throws ExceptionMedicamentosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicamentos filtrarMedicamentoCodigo(int codigoMedicamento) throws ExceptionMedicamentosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }
    
}
