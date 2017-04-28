
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioMedicos extends Serializable {
    
    public void cadastrarMedico(Medicos medico)throws ExceptionMedicosEscrita;
    
    public void atualizarMedico(Medicos medico)throws ExceptionMedicosEscrita;
    
    public void deletarMedico(Long cpf)throws ExceptionMedicosEscrita;
    
    public List<Medicos> listarMedicos()throws ExceptionMedicosLeitura;
    
    public List<Medicos> filtrarMedicoNome(String nome)throws ExceptionMedicosLeitura;
    
    public List<Medicos> filtrarMedicoEspecialidade(String especialidade)throws ExceptionMedicosLeitura;
    
    public Medicos filtrarMedicoCpf(Long cpf)throws ExceptionMedicosLeitura;
    
    public Medicos filtrarMedicoUsuarioSenha(String usuario, String senha)throws ExceptionMedicosLeitura;
}
