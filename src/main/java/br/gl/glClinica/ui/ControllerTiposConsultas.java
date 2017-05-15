
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.TiposConsultas;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionTiposConsultasLeitura;
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
@RequestMapping("/TiposConsultas")
public class ControllerTiposConsultas {
    
    @Autowired
    private Fachada fachada;

    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarTipoConsulta(@RequestBody TiposConsultas tipoConsulta) {
        try {
            this.fachada.cadastrarTipoConsulta(tipoConsulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarTipoConsulta(@RequestBody TiposConsultas tipoConsulta) {
        try {
            this.fachada.atualizarTipoConsulta(tipoConsulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarTipoConsulta(@RequestParam int codigoTipoConsulta) {
        try {
            this.fachada.deletarTipoConsulta(codigoTipoConsulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TiposConsultas> listarTiposConsultas() {
        List<TiposConsultas> tiposConsultas = null;
        try {
            tiposConsultas = this.fachada.listarTiposConsulta();
        } catch (ExceptionTiposConsultasLeitura ex) {
            Logger.getLogger(ControllerTiposConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiposConsultas;
    }
    
        
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TiposConsultas> filtrarTiposConsultasNome(@RequestParam String nomeTipoConsulta) {
        List<TiposConsultas> tiposConsultas = null;
        try {
            tiposConsultas = this.fachada.filtrarTipoConsultaNome(nomeTipoConsulta);
        } catch (ExceptionTiposConsultasLeitura ex) {
            Logger.getLogger(ControllerTiposConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiposConsultas;
    }
    
        
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public TiposConsultas filtrarTiposConsultasCodigo(@RequestParam int codigoTipoConsulta) {
        TiposConsultas tiposConsultas = null;
        try {
            tiposConsultas = this.fachada.filtrarTipoConsultaCodigo(codigoTipoConsulta);
        } catch (ExceptionTiposConsultasLeitura ex) {
            Logger.getLogger(ControllerTiposConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiposConsultas;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
    
    
}
