
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.listarEntidades.ListarFuncionarios;
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
  
  public List<ListarFuncionarios> listarFuncionarios()throws ExceptionFuncionariosLeitura;
  
  public List<ListarFuncionarios> filtrarFuncionariosNome(String nome)throws ExceptionFuncionariosLeitura;
  
  public ListarFuncionarios filtrarFuncionarioCpf(Long cpf)throws ExceptionFuncionariosLeitura;
  
  public ListarFuncionarios filtrarFuncionarioNomeUsuarioAndSenha(String nomeUsuario, String senha)throws ExceptionFuncionariosLeitura;
}
