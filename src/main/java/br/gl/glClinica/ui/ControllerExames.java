
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionExamesLeitura;
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
@RequestMapping("/Exames")
public class ControllerExames {
 
    @Autowired
    private Fachada fachada;

    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarExame(@RequestBody Exames exame) {
        try {
            this.fachada.cadastrarExame(exame);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarExame(@RequestBody Exames exame) {
        try {
            this.fachada.atualizarExame(exame);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarExame(@RequestParam int codigoExame) {
        try {
            this.fachada.deletarExame(codigoExame);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Exames> listarExames() {
        List<Exames> exames = null;
        try {
            exames = this.fachada.listarExame();
        } catch (ExceptionExamesLeitura ex) {
            Logger.getLogger(ControllerExames.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exames;
    }
     
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Exames> filtrarExameNome(@RequestParam String nomeExame) {
        List<Exames> exames = null;
        try {
            exames = this.fachada.filtrarExameNome(nomeExame);
        } catch (ExceptionExamesLeitura ex) {
            Logger.getLogger(ControllerExames.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exames;
    }
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exames filtarExameCodigo(@RequestParam int codigoExame) {
        Exames exames = null;
        try {
            exames = this.fachada.filtrarExameCodigo(codigoExame);
        } catch (ExceptionExamesLeitura ex) {
            Logger.getLogger(ControllerExames.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exames;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }


}
