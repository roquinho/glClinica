
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Receitas;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasLeitura;
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
@RequestMapping("/Receitas")
public class ControllerReceitas {
    
    @Autowired
    private Fachada fachada;

    @RequestMapping("/gerar")
    public ResponseEntity<?> gerarReceita(@RequestBody Receitas receita,@RequestParam Long cpfMedico, @RequestParam Long cpfPaciente) {
        try {
            this.fachada.gerarReceita(receita, cpfMedico, cpfPaciente);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarReceita(@RequestBody Receitas receita) {
        try {
            this.fachada.atualizarReceita(receita);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarReceita(@RequestParam int codigoReceita) {
        try {
            this.fachada.deletarReceita(codigoReceita);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Receitas filtrarReceitaCodigo(@RequestParam int codigoReceita) {
        Receitas receita = null;
        try {
            receita = this.fachada.filtrarReceitaCodigo(codigoReceita);
        } catch (ExceptionReceitasLeitura ex) {
            Logger.getLogger(ControllerReceitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receita;
    }
    
    @RequestMapping("/inserir_Exame")
    public ResponseEntity<?> inserirExameReceita(@RequestParam int codigoReceita, @RequestParam int codigoExame) {
        try {
            this.fachada.inserirExameReceita(codigoReceita, codigoReceita);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/inserir_Medicamento")
    public ResponseEntity<?> inserirMedicamentoReceita(@RequestParam int codigoReceita, @RequestParam int codigoMedicamento) {
        try {
            this.fachada.inserirMedicamentoReceita(codigoReceita, codigoMedicamento);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
    
    
}
