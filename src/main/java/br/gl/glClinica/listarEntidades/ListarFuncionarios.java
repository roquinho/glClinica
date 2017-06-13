
package br.gl.glClinica.listarEntidades;

import br.gl.glClinica.entidades.Funcionarios;
import java.util.Date;

/**
 *
 * @author manoel
 */
public class ListarFuncionarios {
       
    private Long cpf;
    private String nome;
    private String endereco;
    private Long rg;
    private String telefoneCelular;
    private String telefoneFixo;
    private String nomeUsuario;
    private String senha;
    private Date dataCriacao;
    private int contadorAcesso;
    private ListarCargos cargo;
    
    public ListarFuncionarios() {
    }
    
    public ListarFuncionarios(Funcionarios funcionario) {
        this.contadorAcesso = funcionario.getContadorAcesso();
        this.cpf = funcionario.getCpf();
        this.nome = funcionario.getNome();
        this.endereco = funcionario.getEndereco();
        this.rg = funcionario.getRg();
        this.telefoneCelular = funcionario.getTelefoneCelular();
        this.telefoneFixo = funcionario.getTelefoneFixo();
        this.nomeUsuario = funcionario.getNomeUsuario();
        this.senha = funcionario.getSenha();
        this.dataCriacao = funcionario.getDataCriacao();
        
          if(funcionario.getCargo()!=null) {
              this.cargo = new ListarCargos();
              this.cargo.setCodigoCargo(funcionario.getCargo().getCodigoCargo());
              this.cargo.setDescricaoCargo(funcionario.getCargo().getDescricaoCargo());
              this.cargo.setNomeCargo(funcionario.getCargo().getNomeCargo());
          }
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getContadorAcesso() {
        return contadorAcesso;
    }

    public void setContadorAcesso(int contadorAcesso) {
        this.contadorAcesso = contadorAcesso;
    }

    public ListarCargos getCargo() {
        return cargo;
    }

    public void setCargo(ListarCargos cargo) {
        this.cargo = cargo;
    }
     
}
