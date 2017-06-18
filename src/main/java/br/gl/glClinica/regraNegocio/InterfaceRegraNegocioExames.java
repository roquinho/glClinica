
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.listarEntidades.ListarExames;
import br.gl.glClinica.regraNegocioException.ExceptionExamesEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioExames extends Serializable {
    
    public void cadastrarExame(Exames exame)throws ExceptionExamesEscrita;
    
    public void atualizarExame(Exames exame)throws ExceptionExamesEscrita;
    
    public void deletarExame(int codigoExame)throws ExceptionExamesEscrita;
    
    public List<ListarExames> listarExame()throws ExceptionExamesLeitura;
    
    public List<ListarExames> filtrarExameNome(String nomeExame)throws ExceptionExamesLeitura;
    
    public ListarExames filtrarExameCodigo(int codigoExame)throws ExceptionExamesLeitura;
    
   
}
