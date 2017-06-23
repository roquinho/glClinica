
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Receitas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarReceitas {
   
    private int codigoReceita;
    private Date dataReceita;
    private List<ListarMedicamentos> medicamentos;
    private ListarPacientes paciente;
    private List<ListarExames> exames;
    private ListarMedicos medico;
    
    public ListarReceitas() {
    }
    
    public ListarReceitas(Receitas receitas) {
        this.codigoReceita = receitas.getCodigoReceita();
        this.dataReceita = receitas.getDataReceita();
        
          if(receitas.getExames()!=null) {
            this.exames = new ArrayList<>();
             for(int i=0; i<receitas.getExames().size(); i++) {
                 ListarExames listaExames = new ListarExames(receitas.getExames().get(i));
                  this.exames.add(listaExames);
             }
          }
          if(receitas.getMedicamentos()!=null) {
              this.medicamentos = new ArrayList<>();
               for(int i=0;i<receitas.getMedicamentos().size(); i++) {
                   ListarMedicamentos listaMedicamentos = new ListarMedicamentos(receitas.getMedicamentos().get(i));
                     this.medicamentos.add(listaMedicamentos);
               } 
          }
          
    }

    public int getCodigoReceita() {
        return codigoReceita;
    }

    public void setCodigoReceita(int codigoReceita) {
        this.codigoReceita = codigoReceita;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public List<ListarMedicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<ListarMedicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ListarPacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(ListarPacientes paciente) {
        this.paciente = paciente;
    }

    public List<ListarExames> getExames() {
        return exames;
    }

    public void setExames(List<ListarExames> exames) {
        this.exames = exames;
    }

    public ListarMedicos getMedico() {
        return medico;
    }

    public void setMedico(ListarMedicos medico) {
        this.medico = medico;
    }
    
    

}
