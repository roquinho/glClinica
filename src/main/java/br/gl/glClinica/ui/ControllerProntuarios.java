
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Prontuarios;
import br.gl.glClinica.listarEntidades.ListarProntuarios;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionProntuariosLeitura;
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
@RequestMapping("/Prontuarios")
public class ControllerProntuarios {
    
    @Autowired
    private Fachada fachada;

    
     @RequestMapping("/gerar")
    public ResponseEntity<?> gerarProntuario(@RequestBody Prontuarios prontuario, @RequestParam Long cpfPaciente) {
        try {
            this.fachada.gerarProntuario(prontuario,cpfPaciente);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarProntuario(@RequestBody Prontuarios prontuario) {
        try {
            this.fachada.atualizarProntuario(prontuario);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarProntuario(@RequestParam int codigoProntuario) {
        try {
            this.fachada.deletarProntuario(codigoProntuario);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarProntuarios filtrarProntuarioCodigo(@RequestParam int codigoProntuario) {
        ListarProntuarios prontuario = null;
        try {
            prontuario = this.fachada.filtrarProntuarioCodigo(codigoProntuario);
        } catch (ExceptionProntuariosLeitura ex) {
            Logger.getLogger(ControllerProntuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prontuario;
    }



}
