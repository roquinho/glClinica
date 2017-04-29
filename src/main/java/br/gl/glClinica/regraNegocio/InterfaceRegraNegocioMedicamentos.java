
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioMedicamentos extends Serializable {
    
    public void cadastrarMedicamento(Medicamentos medicamento)throws ExceptionMedicamentosEscrita;
    
    public void atualizarMedcicamento(Medicamentos medicamento)throws ExceptionMedicamentosEscrita;
    
    public void deletarMedicamento(int codigoMedicamento)throws ExceptionMedicamentosEscrita;
    
    public List<Medicamentos> listarMedicamentos()throws ExceptionMedicamentosLeitura;
    
    public List<Medicamentos> filtrarMedicamentoNome(String nomeMedicamento)throws ExceptionMedicamentosLeitura;
    
    public List<Medicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio)throws ExceptionMedicamentosLeitura;
    
    public Medicamentos filtrarMedicamentoCodigo(int codigoMedicamento)throws ExceptionMedicamentosLeitura;

}
