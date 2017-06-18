
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Receitas;
import br.gl.glClinica.listarEntidades.ListarReceitas;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasLeitura;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioReceitas extends Serializable {
    
 public void gerarReceita(Receitas receita, Long cpfMedico, Long cpfPaciente)throws ExceptionReceitasEscrita;
 
 public void atualizarReceita(Receitas receita)throws ExceptionReceitasEscrita;
 
 public void deletarReceita(int codigoReceita)throws ExceptionReceitasEscrita;
 
 public ListarReceitas filtrarReceitaCodigo(int codigoReceita)throws ExceptionReceitasLeitura;
 
 public void inserirExameReceita(int codigoReceita, int codigoExame)throws ExceptionReceitasEscrita;
 
 public void inserirMedicamentoReceita(int codigoReceita, int codigoMedicamento)throws ExceptionReceitasEscrita;
    
}
