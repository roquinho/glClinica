
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Convenios;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionConveniosLeitura;
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
@RequestMapping("/Convenios")

public class ControllerConvenios {
    
    @Autowired
    private Fachada fachada;
    
    
    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarConvenio(@RequestBody Convenios convenio) {
        try {
            this.fachada.cadastrarConvenio(convenio);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarConvenio(@RequestBody Convenios convenio) {
        try {
            this.fachada.atualizarConvenio(convenio);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarConvenio(@RequestParam int codigoConvenio) {
        try {
            this.fachada.deletarConvenio(codigoConvenio);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Convenios> listarConvenios() {
        List<Convenios> convenios = null;
        try {
            convenios = this.fachada.listarConvenios();
        } catch (ExceptionConveniosLeitura ex) {
            Logger.getLogger(ControllerConvenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenios;
    }
 
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Convenios filtrarConvenioCodigo(@RequestParam int codigoConvenio) {
        Convenios convenio = null;
        try {
            convenio = this.fachada.filtrarConvenioCodigo(codigoConvenio);
        } catch (ExceptionConveniosLeitura ex) {
            Logger.getLogger(ControllerConvenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenio;
    }
    
     @RequestMapping(value = "/filtrarNome",produces = MediaType.APPLICATION_JSON_VALUE)
     public List<Convenios> filtrarConvenioNome(@RequestParam String nomeConvenio) {
       List<Convenios> convenios = null;
        try {
            convenios = this.fachada.filtrarConvenioNome(nomeConvenio);
        } catch (ExceptionConveniosLeitura ex) {
            Logger.getLogger(ControllerConvenios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenios;
     }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

     
    



}
