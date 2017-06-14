
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.TiposConsultas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarTiposConsultas {
    
    private int codigoTipoConsulta;
    private String nomeTipoConsulta;
    private double valorTipoConsulta;
    private List<ListarConsultas> consultas;
    
    public ListarTiposConsultas() {
    }
    
    public ListarTiposConsultas(TiposConsultas tipoConsulta) {
        this.codigoTipoConsulta = tipoConsulta.getCodigoTipoConsulta();
        this.nomeTipoConsulta = tipoConsulta.getNomeTipoConsulta();
        this.valorTipoConsulta = tipoConsulta.getValorTipoConsulta();
        
           if(tipoConsulta.getConsultas()!=null) {
             this.consultas = new ArrayList<>();
               for(int i=0; i<tipoConsulta.getConsultas().size(); i++) {
                 ListarConsultas listaConsultas = new ListarConsultas(tipoConsulta.getConsultas().get(i));
                  this.consultas.add(listaConsultas);
               }
           }
    }

    public int getCodigoTipoConsulta() {
        return codigoTipoConsulta;
    }

    public void setCodigoTipoConsulta(int codigoTipoConsulta) {
        this.codigoTipoConsulta = codigoTipoConsulta;
    }

    public String getNomeTipoConsulta() {
        return nomeTipoConsulta;
    }

    public void setNomeTipoConsulta(String nomeTipoConsulta) {
        this.nomeTipoConsulta = nomeTipoConsulta;
    }

    public double getValorTipoConsulta() {
        return valorTipoConsulta;
    }

    public void setValorTipoConsulta(double valorTipoConsulta) {
        this.valorTipoConsulta = valorTipoConsulta;
    }

    public List<ListarConsultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ListarConsultas> consultas) {
        this.consultas = consultas;
    }
    
    
  
}
