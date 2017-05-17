
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Clinica;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionClinicaLeitura;
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
@RequestMapping("/Clinicas")
public class ControllerClinica {
    
    @Autowired
    private Fachada fachada;
    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCLinica(@RequestBody Clinica clinica) {
        try {
            this.fachada.cadastrarClinica(clinica);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarCLinica(@RequestBody Clinica clinica) {
        try {
            this.fachada.atualizarClinica(clinica);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarCLinica(@RequestParam String cnpj) {
        try {
            this.fachada.deletarClinica(cnpj);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clinica> listarCLinica() {
        List<Clinica> clinica = null;
        try {
            clinica = this.fachada.listarClinicas();
        } catch (ExceptionClinicaLeitura ex) {
            Logger.getLogger(ControllerClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinica;
    }
 
    @RequestMapping(value = "/filtrarCnpj", produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinica filtrarClinicaCnpj(@RequestParam String cnpj) {
        Clinica clinica = null;
        try {
            clinica = this.fachada.filtrarClinicaCnpj(cnpj);
        } catch (ExceptionClinicaLeitura ex) {
            Logger.getLogger(ControllerClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinica;
    }
    
     @RequestMapping(value = "/filtrarNome",produces = MediaType.APPLICATION_JSON_VALUE)
     public List<Clinica> filtrarCLinicaNome(@RequestParam String nomeClinica) {
       List<Clinica> clinica = null;
        try {
            clinica = this.fachada.filtrarClinicaNome(nomeClinica);
        } catch (ExceptionClinicaLeitura ex) {
            Logger.getLogger(ControllerClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clinica;
     }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
      
}
