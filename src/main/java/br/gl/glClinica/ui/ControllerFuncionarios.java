
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Funcionarios;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionFuncionariosLeitura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manoel
 */
@Controller
@RestController
@RequestMapping("/Funcionarios")
public class ControllerFuncionarios {
    
    @Autowired
    private Fachada fachada;
    
    
    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody Funcionarios funcionario,@RequestParam int codigoCargo) {
        try {
            this.fachada.cadastrarFuncionario(funcionario, codigoCargo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarFuncionario(@RequestBody Funcionarios funcionario) {
        try {
            this.fachada.atualizarFuncionario(funcionario);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarFuncionario(@RequestParam Long cpf) {
        try {
            this.fachada.deletarFuncionario(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Funcionarios> listarFuncionarios() {
        List<Funcionarios> funcionarios = null;
        try {
            funcionarios = this.fachada.listarFuncionarios();
        } catch (ExceptionFuncionariosLeitura ex) {
            Logger.getLogger(ControllerFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Funcionarios> filtrarFuncionarioNome(@RequestParam String nomeFuncionario) {
        List<Funcionarios> funcionarios = null;
        try {
            funcionarios = this.fachada.filtrarFuncionariosNome(nomeFuncionario);
        } catch (ExceptionFuncionariosLeitura ex) {
            Logger.getLogger(ControllerFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
    @RequestMapping(value = "/filtrarCpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionarios filtrarFuncionarioCpf(@RequestParam Long cpf) {
        Funcionarios funcionarios = null;
        try {
            funcionarios = this.fachada.filtrarFuncionarioCpf(cpf);
        } catch (ExceptionFuncionariosLeitura ex) {
            Logger.getLogger(ControllerFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
    @RequestMapping(value = "/filtrarLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Funcionarios filtrarNomeUsuarioAndSenha(@RequestParam String nomeUsuario, @RequestParam String senha) {
        Funcionarios funcionarios = null;
        try {
            funcionarios = this.fachada.filtrarFuncionarioNomeUsuarioAndSenha(nomeUsuario, senha);
        } catch (ExceptionFuncionariosLeitura ex) {
            Logger.getLogger(ControllerFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }



}
