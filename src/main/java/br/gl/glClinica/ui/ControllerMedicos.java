
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Medicos;
import br.gl.glClinica.listarEntidades.ListarMedicos;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionMedicosLeitura;
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
@RequestMapping("/Medicos")
public class ControllerMedicos {
    
    @Autowired
    private Fachada fachada;
    
    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarMedico(@RequestBody Medicos medico) {
        try {
            this.fachada.cadastrarMedico(medico);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarMedico(@RequestBody Medicos medico) {
        try {
            this.fachada.atualizarMedico(medico);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarMedico(@RequestParam Long cpf) {
        try {
            this.fachada.deletarMedico(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarMedicos> listarMedicos() {
        List<ListarMedicos> medicos = null;
        try {
            medicos = this.fachada.listarMedicos();
        } catch (ExceptionMedicosLeitura ex) {
            Logger.getLogger(ControllerMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarMedicos> filtrarMedicoNome(@RequestParam String nomeMedico) {
        List<ListarMedicos> medicos = null;
        try {
            medicos = this.fachada.filtrarMedicoNome(nomeMedico);
        } catch (ExceptionMedicosLeitura ex) {
            Logger.getLogger(ControllerMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
 
    @RequestMapping(value = "/filtrarEspecialidade", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarMedicos> filtrarMedicoEspecialidade(@RequestParam String especialidade) {
        List<ListarMedicos> medicos = null;
        try {
            medicos = this.fachada.filtrarMedicoEspecialidade(especialidade);
        } catch (ExceptionMedicosLeitura ex) {
            Logger.getLogger(ControllerMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
    @RequestMapping(value = "/filtrarCpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarMedicos filtrarMedicoCpf(@RequestParam Long cpf) {
        ListarMedicos medicos = null;
        try {
            medicos = this.fachada.filtrarMedicoCpf(cpf);
        } catch (ExceptionMedicosLeitura ex) {
            Logger.getLogger(ControllerMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
    @RequestMapping(value = "/filtrarLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarMedicos filtrarMedicoUsuarioAndSenha(@RequestParam String nomeUsuario, @RequestParam String senha) {
        ListarMedicos medicos = null;
        try {
            medicos = this.fachada.filtrarMedicoUsuarioSenha(nomeUsuario, senha);
        } catch (ExceptionMedicosLeitura ex) {
            Logger.getLogger(ControllerMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    } 

}
