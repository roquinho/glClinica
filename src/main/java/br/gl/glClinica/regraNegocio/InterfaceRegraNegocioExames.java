
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
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
    
    public List<Exames> listarExame()throws ExceptionExamesLeitura;
    
    public List<Exames> filtrarExameNome(String nomeExame)throws ExceptionExamesLeitura;
    
    public Exames filtrarExameCodigo(int codigoExame)throws ExceptionExamesLeitura;
    
   
}
