
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Convenios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author manoel
 */
public class ListarConvenios {
  
    private int codigoConvenio;
    private String nomeConvenio;
    private Date dataInicio;
    private String regioesCobertas;
    private List<ListarPacientes> pacientes;
    
    public ListarConvenios() {
    }
    
    public ListarConvenios(Convenios convenio) {
        this.codigoConvenio = convenio.getCodigoConvenio();
        this.dataInicio = convenio.getDataInicio();
        this.nomeConvenio = convenio.getNomeConvenio();
        this.regioesCobertas = convenio.getRegioesCobertas();
        
          if(convenio.getPacientes()!=null) {
              this.pacientes = new ArrayList<>();
                for(int i=0; i<convenio.getPacientes().size(); i++) {
                    ListarPacientes listaPacientes = new ListarPacientes();
                      this.pacientes.add(listaPacientes);
                      
                        this.pacientes.get(i).setCpf(convenio.getPacientes().get(i).getCpf());
                        this.pacientes.get(i).setDataNascimento(convenio.getPacientes().get(i).getDataNascimento());
                        this.pacientes.get(i).setEmail(convenio.getPacientes().get(i).getEmail());
                        this.pacientes.get(i).setEndereco(convenio.getPacientes().get(i).getEndereco());
                        this.pacientes.get(i).setLoginNome(convenio.getPacientes().get(i).getLoginNome());
                        this.pacientes.get(i).setNome(convenio.getPacientes().get(i).getNome());
                        this.pacientes.get(i).setNomeMae(convenio.getPacientes().get(i).getNomeMae());
                        this.pacientes.get(i).setNomePai(convenio.getPacientes().get(i).getNomePai());
                        this.pacientes.get(i).setNumeroCarteira(convenio.getPacientes().get(i).getNumeroCarteira());
                        this.pacientes.get(i).setQuantidadeAcessos(convenio.getPacientes().get(i).getQuantidadeAcessos());
                        this.pacientes.get(i).setRg(convenio.getPacientes().get(i).getRg());
                        this.pacientes.get(i).setSenha(convenio.getPacientes().get(i).getSenha());
                        this.pacientes.get(i).setSexo(convenio.getPacientes().get(i).getSexo());
                        this.pacientes.get(i).setTelefoneCelular(convenio.getPacientes().get(i).getTelefoneCelular());
                        this.pacientes.get(i).setTelefoneFixo(convenio.getPacientes().get(i).getTelefoneFixo());
                        
                }
          }
        
           
    }

    public int getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(int codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getRegioesCobertas() {
        return regioesCobertas;
    }

    public void setRegioesCobertas(String regioesCobertas) {
        this.regioesCobertas = regioesCobertas;
    }

    public List<ListarPacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<ListarPacientes> pacientes) {
        this.pacientes = pacientes;
    }
    
}
