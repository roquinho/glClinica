
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.persistencia.InterfaceRepositorioCargos;
import br.gl.glClinica.persistencia.InterfaceRepositorioFuncionarios;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioFuncionarios implements InterfaceRegraNegocioFuncionarios {

    @Autowired
    private InterfaceRepositorioFuncionarios repositorioFuncionarios;
    @Autowired
    private InterfaceRepositorioCargos repositorioCargos;
    
    @Override
    public void cadastrarFuncionario(Funcionarios funcionario, int codigoCargo) throws ExceptionFuncionariosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarFuncionario(Funcionarios funcionario) throws ExceptionFuncionariosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarFuncionario(Long cpf) throws ExceptionFuncionariosEscrita {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionarios> listarFuncionarios() throws ExceptionFuncionariosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionarios> filtrarFuncionariosNome(String nome) throws ExceptionFuncionariosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionarios filtrarFuncionarioCpf(Long cpf) throws ExceptionFuncionariosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha) throws ExceptionFuncionariosLeitura {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InterfaceRepositorioFuncionarios getRepositorioFuncionarios() {
        return repositorioFuncionarios;
    }

    public void setRepositorioFuncionarios(InterfaceRepositorioFuncionarios repositorioFuncionarios) {
        this.repositorioFuncionarios = repositorioFuncionarios;
    }

    public InterfaceRepositorioCargos getRepositorioCargos() {
        return repositorioCargos;
    }

    public void setRepositorioCargos(InterfaceRepositorioCargos repositorioCargos) {
        this.repositorioCargos = repositorioCargos;
    }
    
}
