
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Pacientes;
import br.gl.glClinica.listarEntidades.ListarPacientes;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionPacientesLeitura;
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
@RequestMapping("/Pacientes")
public class ControllerPacientes {
    
    @Autowired
    private Fachada fachada;

    @RequestMapping("/cadastrar")
    public ResponseEntity<?> cadastrarPaciente(@RequestBody Pacientes paciente) {
        try {
            this.fachada.cadastrarPaciente(paciente);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarPaciente(@RequestBody Pacientes paciente) {
        try {
            this.fachada.atualizarPacientes(paciente);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/deletar")
    public ResponseEntity<?> deletarPaciente(@RequestParam Long cpf) {
        try {
            this.fachada.deletarPaciente(cpf);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarPacientes> listarPacientes() {
        List<ListarPacientes> pacientes = null;
        try {
            pacientes = this.fachada.listarPacientes();
        } catch (ExceptionPacientesLeitura ex) {
            Logger.getLogger(ControllerPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
 
    @RequestMapping(value = "/filtrarNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarPacientes> filtrarPacientesNome(@RequestParam String nome) {
        List<ListarPacientes> pacientes = null;
        try {
            pacientes = this.fachada.filtrarPacientesNome(nome);
        } catch (ExceptionPacientesLeitura ex) {
            Logger.getLogger(ControllerPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }
    
    @RequestMapping(value = "/filtrarCpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarPacientes filtrarPacienteCpf(@RequestParam Long cpf) {
        ListarPacientes paciente = null;
        try {
            paciente = this.fachada.filtrarPacientesCpf(cpf);
        } catch (ExceptionPacientesLeitura ex) {
            Logger.getLogger(ControllerPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }
    
    @RequestMapping(value = "/filtrarLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarPacientes filtrarPacientesUsuarioAndSenha(@RequestParam String usuario, @RequestParam String senha) {
        ListarPacientes paciente = null;
        try {
            paciente = this.fachada.filtrarPacientesLoginNomeAndSenha(usuario, senha);
        } catch (ExceptionPacientesLeitura ex) {
            Logger.getLogger(ControllerPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }
    @RequestMapping("/receitar_Medicamento")
    public ResponseEntity<?> receitarMedicamentoPaciente(@RequestParam Long cpfPaciente, @RequestParam int codigoMedicamento) {
        try {
            this.fachada.receitarMedicamentoPaciente(cpfPaciente, codigoMedicamento);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/marcar_Exame")
    public ResponseEntity<?> marcarExamePaciente(@RequestParam Long cpfPaciente, @RequestParam int codigoExame) {
        try {
            this.fachada.marcarExamePaciente(cpfPaciente, codigoExame);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/inserir_Convenio")
    public ResponseEntity<?> inserirConvenioPaciente(@RequestParam Long cpfPaciente, @RequestParam int codigoConvenio) {
        try {
            this.fachada.InserirConvenioPaciente(cpfPaciente, codigoConvenio);
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
