
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Laudos;
import br.gl.glClinica.listarEntidades.ListarLaudos;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionLaudosLeitura;
import java.util.Date;
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
@RequestMapping("/Laudos")
public class ControllerLaudos {
    
    @Autowired
    private Fachada fachada;

    
    @RequestMapping("/gerar")
    public ResponseEntity<?> gerarLaudo(@RequestBody Laudos laudo, @RequestParam Long cpfMedico,@RequestParam Long cpfPaciente,@RequestParam int codigoExame) {
        try {
            this.fachada.gerarLaudo(laudo, cpfMedico, cpfPaciente,codigoExame);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarLaudo(@RequestBody Laudos laudo) {
        try {
            this.fachada.atualizarLaudo(laudo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarLaudo(@RequestParam int codigoLaudo) {
        try {
            this.fachada.deletarLaudo(codigoLaudo);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/filtrarData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarLaudos> filtrarLaudoData(@RequestParam Date dataLaudo) {
        List<ListarLaudos> laudos = null;
        try {
            laudos = this.fachada.filtrarLaudoData(dataLaudo);
        } catch (ExceptionLaudosLeitura ex) {
            Logger.getLogger(ControllerLaudos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laudos;
    }

    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarLaudos filtrarLaudoCodigo(@RequestParam int codigoLaudo) {
        ListarLaudos laudo = null;
        try {
            laudo = this.fachada.filtrarLaudoCodigo(codigoLaudo);
        } catch (ExceptionLaudosLeitura ex) {
            Logger.getLogger(ControllerLaudos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laudo;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

}
