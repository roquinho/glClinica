
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Receitas;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioReceitas;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasLeitura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioReceitas implements InterfaceRegraNegocioReceitas {

    @Autowired
    private InterfaceRepositorioReceitas repositorioReceitas;
    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
    
    @Override
    public void gerarReceita(Receitas receita, Long cpfMedico, Long cpfPaciente) throws ExceptionReceitasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarReceita(Receitas receita) throws ExceptionReceitasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarReceita(int codigoReceita) throws ExceptionReceitasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Receitas filtrarReceitaCodigo(int codigoReceita) throws ExceptionReceitasLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirExameReceita(int codigoReceita, int codigoExame) throws ExceptionReceitasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirMedicamentoReceita(int codigoReceita, int codigoMedicamento) throws ExceptionReceitasEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioReceitas getRepositorioReceitas() {
        return repositorioReceitas;
    }

    public void setRepositorioReceitas(InterfaceRepositorioReceitas repositorioReceitas) {
        this.repositorioReceitas = repositorioReceitas;
    }

    public InterfaceRepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public void setRepositorioMedicos(InterfaceRepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }

    public InterfaceRepositorioPacientes getRepositorioPacientes() {
        return repositorioPacientes;
    }

    public void setRepositorioPacientes(InterfaceRepositorioPacientes repositorioPacientes) {
        this.repositorioPacientes = repositorioPacientes;
    }

    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }

    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }
    
}
