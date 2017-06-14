
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.Consultas;
import br.gl.glClinica.listarEntidades.ListarConsultas;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionConsultasLeitura;
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
@RequestMapping("/Consultas")
public class ControllerConsultas {
    
    @Autowired
    private Fachada fachada;

    @RequestMapping("/marcar")
    public ResponseEntity<?> marcarConsulta(@RequestBody Consultas consulta,@RequestParam Long cpfMedico,@RequestParam Long cpfPaciente,@RequestParam int codigoTipoConsulta) {
        try {
            this.fachada.marcarConsulta(consulta, cpfMedico, cpfPaciente, codigoTipoConsulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/atualizar")
    public ResponseEntity<?> atualizarConsulta(@RequestBody Consultas consulta) {
        try {
            this.fachada.atualizarConsulta(consulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping("/desmarcar")
    public ResponseEntity<?> desmarcarConsulta(@RequestParam int codigoConsulta) {
        try {
            this.fachada.desmarcarConsulta(codigoConsulta);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarConsultas> listarConsultas() {
        List<ListarConsultas> consulta = null;
        try {
            consulta = this.fachada.listarConsultas();
        } catch (ExceptionConsultasLeitura ex) {
            Logger.getLogger(ControllerConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
 
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarConsultas filtrarConsultaCodigo(@RequestParam int codigoConsulta) {
        ListarConsultas consulta = null;
        try {
            consulta = this.fachada.filtrarConsultaCodigo(codigoConsulta);
        } catch (ExceptionConsultasLeitura ex) {
            Logger.getLogger(ControllerConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
    
    @RequestMapping(value = "/filtrarData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListarConsultas> filtrarConsultaDataConsulta(@RequestParam Date dataConsulta) {
        List<ListarConsultas> consulta = null;
        try {
            consulta = this.fachada.filtrarConsultaDataConsulta(dataConsulta);
        } catch (ExceptionConsultasLeitura ex) {
            Logger.getLogger(ControllerConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
 
    @RequestMapping(value = "/filtrarDataAndHora", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListarConsultas filtrarConsultaDataAndHora(@RequestParam Date dataConsulta, @RequestParam Date horaConsulta) {
        ListarConsultas consulta = null;
        try {
            consulta = this.fachada.filtrarConsultaDataAndHoraConsulta(dataConsulta, horaConsulta);
        } catch (ExceptionConsultasLeitura ex) {
            Logger.getLogger(ControllerConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
  
    
    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
    
    
}
