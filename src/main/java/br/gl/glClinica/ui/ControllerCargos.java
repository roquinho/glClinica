
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Cargos;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionCargosLeitura;
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
@RequestMapping("/Cargos")
public class ControllerCargos {
    
    @Autowired
    private Fachada fachada;
    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCargo(@RequestBody Cargos cargo) {
        try {
            this.fachada.cadastrarCargo(cargo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarCargo(@RequestBody Cargos cargo) {
        try {
            this.fachada.atualizarCargo(cargo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarCargo(@RequestParam int codigoCargo) {
        try {
            this.fachada.deletarCargo(codigoCargo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cargos> listarCargos() {
        List<Cargos> cargos = null;
        try {
            cargos = this.fachada.listarCargos();
        } catch (ExceptionCargosLeitura ex) {
            Logger.getLogger(ControllerCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }
 
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cargos filtrarCargosCodigo(@RequestParam int codigoCargo) {
        Cargos cargos = null;
        try {
            cargos = this.fachada.filtrarCargoCodigo(codigoCargo);
        } catch (ExceptionCargosLeitura ex) {
            Logger.getLogger(ControllerCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }
    
     @RequestMapping(value = "/filtrarNome",produces = MediaType.APPLICATION_JSON_VALUE)
     public List<Cargos> filtrarCargoNome(@RequestParam String nomeCargo) {
       List<Cargos> cargos = null;
        try {
            cargos = this.fachada.filtrarCargoNome(nomeCargo);
        } catch (ExceptionCargosLeitura ex) {
            Logger.getLogger(ControllerCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
     }
      
     

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
 
}
