
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionMedicamentosLeitura;
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
@RequestMapping("/Medicamentos")
public class ControllerMedicamentos {
 
    @Autowired
    private Fachada fachada;

    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarMedicamento(@RequestBody Medicamentos medicamento) {
        try {
            this.fachada.cadastrarMedicamento(medicamento);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarMedicamento(@RequestBody Medicamentos medicamento) {
        try {
            this.fachada.atualizarMedcicamento(medicamento);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarMedicamento(@RequestParam int codigoMedicamento) {
        try {
            this.fachada.deletarMedicamento(codigoMedicamento);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicamentos> listarMedicamentos() {
        List<Medicamentos> medicamentos = null;
        try {
            medicamentos = this.fachada.listarMedicamentos();
        } catch (ExceptionMedicamentosLeitura ex) {
            Logger.getLogger(ControllerMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicamentos;
    }
    
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicamentos> filtrarMedicamentosNome(@RequestParam String nomeMedicamento) {
        List<Medicamentos> medicamentos = null;
        try {
            medicamentos = this.fachada.filtrarMedicamentoNome(nomeMedicamento);
        } catch (ExceptionMedicamentosLeitura ex) {
            Logger.getLogger(ControllerMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicamentos;
    }
    
    @RequestMapping(value = "/filtrarLaboratorio", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicamentos> filtrarMedicamentosLaboratorio(@RequestParam String nomeLaboratorio) {
        List<Medicamentos> medicamentos = null;
        try {
            medicamentos = this.fachada.filtrarMedicamentosLaboratorio(nomeLaboratorio);
        } catch (ExceptionMedicamentosLeitura ex) {
            Logger.getLogger(ControllerMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicamentos;
    }
    
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicamentos filtrarMedicamentosCodigo(@RequestParam int codigoMedicamento) {
        Medicamentos medicamentos = null;
        try {
            medicamentos = this.fachada.filtrarMedicamentoCodigo(codigoMedicamento);
        } catch (ExceptionMedicamentosLeitura ex) {
            Logger.getLogger(ControllerMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicamentos;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
 
}
