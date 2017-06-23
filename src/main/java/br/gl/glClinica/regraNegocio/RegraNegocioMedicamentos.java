
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.listarEntidades.ListarMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
import java.util.ArrayList;
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
    public List<ListarMedicamentos> listarMedicamentos() throws ExceptionMedicamentosLeitura {
      List<ListarMedicamentos> listaListarMedicamentos = null;     
        List<Medicamentos> listaMedicamentosBD = this.repositorioMedicamentos.findAll();
           if(listaMedicamentosBD!=null) {
               listaListarMedicamentos = new ArrayList<>();
                 for(int i=0; i<listaMedicamentosBD.size(); i++) {
                     ListarMedicamentos listaMedicamentos = new ListarMedicamentos(listaMedicamentosBD.get(i));
                       listaListarMedicamentos.add(listaMedicamentos);
        
           }
           }
           return listaListarMedicamentos;  
    }

    @Override
    public List<ListarMedicamentos> filtrarMedicamentoNome(String nomeMedicamento) throws ExceptionMedicamentosLeitura {
      List<ListarMedicamentos> listaListarMedicamentos =null;
      
        if(nomeMedicamento == null) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            List<Medicamentos> listaMedicamentosBD = this.repositorioMedicamentos.findByNomeMedicamentoStartingWith(nomeMedicamento);
         if(listaMedicamentosBD!=null) {
               listaListarMedicamentos = new ArrayList<>();
                 for(int i=0; i<listaMedicamentosBD.size(); i++) {
                     ListarMedicamentos listaMedicamentos = new ListarMedicamentos(listaMedicamentosBD.get(i));
                       listaListarMedicamentos.add(listaMedicamentos);
           
        }
         }
    }
        return listaListarMedicamentos;
    }

    @Override
    public List<ListarMedicamentos> filtrarMedicamentosLaboratorio(String nomeLaboratorio) throws ExceptionMedicamentosLeitura {
      List<ListarMedicamentos> listaListarMedicamentos = null;
      
        if(nomeLaboratorio == null) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            List<Medicamentos> listaMedicamentosBD =this.repositorioMedicamentos.findByNomeLaboratorioStartingWith(nomeLaboratorio);
        if(listaMedicamentosBD!=null) {
               listaListarMedicamentos = new ArrayList<>();
                 for(int i=0; i<listaMedicamentosBD.size(); i++) {
                     ListarMedicamentos listaMedicamentos = new ListarMedicamentos(listaMedicamentosBD.get(i));
                       listaListarMedicamentos.add(listaMedicamentos);
                 }
        }    
        }
        return listaListarMedicamentos;
    }

    @Override
    public ListarMedicamentos filtrarMedicamentoCodigo(int codigoMedicamento) throws ExceptionMedicamentosLeitura {
       ListarMedicamentos listaMedicamentos = null;
       
        if(codigoMedicamento <= 0) {
            throw new ExceptionMedicamentosLeitura();
        }
        else {
            Medicamentos medicamento = this.repositorioMedicamentos.findByCodigoMedicamento(codigoMedicamento);
        if(medicamento!=null) {
               listaMedicamentos = new ListarMedicamentos(medicamento);
        }    
        }
        return listaMedicamentos;
    }

    
    
    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }
    
}
