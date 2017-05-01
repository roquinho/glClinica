
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioMedicamentos implements InterfaceRegraNegocioMedicamentos {

    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
   
    
    
    @Override
    public void cadastrarMedicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
      
        if(medicamento == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getContraIndicacoes()==null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getNomeLaboratorio() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getNomeMedicamento() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getPosologiaIndicada() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getSubstanciaAtiva() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        else {
            this.repositorioMedicamentos.save(medicamento);
        }
    }

    @Override
    public void atualizarMedcicamento(Medicamentos medicamento) throws ExceptionMedicamentosEscrita {
        
        
        if(medicamento == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getCodigoMedicamento() <= 0) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getContraIndicacoes()==null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getNomeLaboratorio() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getNomeMedicamento() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getPosologiaIndicada() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(medicamento.getSubstanciaAtiva() == null) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(this.repositorioMedicamentos.exists(medicamento.getCodigoMedicamento())==false) {
            throw new ExceptionMedicamentosEscrita();
        }
        else {
            Medicamentos novoMedicamento = this.repositorioMedicamentos.findByCodigoMedicamento(medicamento.getCodigoMedicamento());
               
                novoMedicamento.setContraIndicacoes(medicamento.getContraIndicacoes());
                novoMedicamento.setGenerico(medicamento.getGenerico());
                novoMedicamento.setNomeLaboratorio(medicamento.getNomeLaboratorio());
                novoMedicamento.setNomeMedicamento(medicamento.getNomeMedicamento());
                novoMedicamento.setPosologiaIndicada(medicamento.getPosologiaIndicada());
                novoMedicamento.setSubstanciaAtiva(medicamento.getSubstanciaAtiva());
                
                   this.repositorioMedicamentos.save(novoMedicamento);
        }
        
    }

    @Override
    public void deletarMedicamento(int codigoMedicamento) throws ExceptionMedicamentosEscrita {
       
        if(codigoMedicamento <= 0) {
            throw new ExceptionMedicamentosEscrita();
        }
        if(this.repositorioMedicamentos.exists(codigoMedicamento)==false) {
            throw new ExceptionMedicamentosEscrita();
        }
        else {
            this.repositorioMedicamentos.delete(codigoMedicamento);
        }
    }

    @Override
    public List<Medicamentos> listarMedicamentos() throws ExceptionMedicamentosLeitura {
       
        return this.repositorioMedicamentos.findAll();
    }

    @Override
    public List<Medicamentos> filtrarMedicamentoNome(String nomeMedicamento) throws ExceptionMedicamentosLeitura {
       
        if(nomeMedicamento == null) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            return this.repositorioMedicamentos.findByNomeMedicamentoStartingWith(nomeMedicamento);
        }
    }

    @Override
    public List<Medicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio) throws ExceptionMedicamentosLeitura {
       
        if(nomeLaboratorio == null) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            return this.repositorioMedicamentos.findByNomeLaboratorioStartingWith(nomeLaboratorio);
        }
    }

    @Override
    public Medicamentos filtrarMedicamentoCodigo(int codigoMedicamento) throws ExceptionMedicamentosLeitura {
        
        if(codigoMedicamento <= 0) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            return this.repositorioMedicamentos.findByCodigoMedicamento(codigoMedicamento);
        }
    }

    
    
    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }
    
}
