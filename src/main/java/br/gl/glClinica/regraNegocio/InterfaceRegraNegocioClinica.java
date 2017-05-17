
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioClinica extends Serializable {
    
    public void cadastrarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void atualizarClinica(Clinica clinica)throws ExceptionClinicaEscrita;
    
    public void deletarClinica(String cnpj)throws ExceptionClinicaEscrita;
    
    public List<Clinica> listarClinicas()throws ExceptionClinicaLeitura;
    
    public List<Clinica> filtrarClinicaNome(String nome)throws ExceptionClinicaLeitura;
    
    public Clinica filtrarClinicaCnpj(String cnpj)throws ExceptionClinicaLeitura;
}
