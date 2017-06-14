
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Cargos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarCargos {
    
    private int codigoCargo;
    private String descricaoCargo;
    private String nomeCargo;
    private List<ListarFuncionarios>funcionarios;
    
    public ListarCargos() {        
    }
    
    public ListarCargos(Cargos cargo) {
        this.codigoCargo = cargo.getCodigoCargo();
        this.descricaoCargo = cargo.getDescricaoCargo();
        this.nomeCargo = cargo.getNomeCargo();
        
         
           if(cargo.getFuncionarios()!=null) {
              this.funcionarios = new ArrayList<>(); 
               for(int i=0; i<cargo.getFuncionarios().size(); i++) {
                   ListarFuncionarios listaFuncionarios = new ListarFuncionarios(cargo.getFuncionarios().get(i));
                    this.funcionarios.add(listaFuncionarios);
               }
           }
        
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public List<ListarFuncionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<ListarFuncionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
}
