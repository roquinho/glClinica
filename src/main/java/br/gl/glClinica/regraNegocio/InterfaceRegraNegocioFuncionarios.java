
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioFuncionarios extends Serializable {
    
  public void cadastrarFuncionario(Funcionarios fincionario, int codigoCargo)throws ExceptionFuncionariosEscrita;
  
  public void atualizarFuncionario(Funcionarios funcionario)throws ExceptionFuncionariosEscrita;
  
  public void deletarFuncionario(Long cpf)throws ExceptionFuncionariosEscrita;
  
  public List<Funcionarios> listarFuncionarios()throws ExceptionFuncionariosLeitura;
  
  public List<Funcionarios> filtrarFuncionariosNome(String nome)throws ExceptionFuncionariosLeitura;
  
  public Funcionarios filtrarFuncionarioCpf(Long cpf)throws ExceptionFuncionariosLeitura;
  
  public Funcionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha)throws ExceptionFuncionariosLeitura;
}
