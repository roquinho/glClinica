
package br.gl.glClinica.ui;

import br.gl.glClinica.entidades.LogAcesso;
import br.gl.glClinica.regraNegocio.Fachada;
import br.gl.glClinica.regraNegocioException.ExceptionLogAcessoLeitura;
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
@RequestMapping("/LogAcesso")
public class ControllerLogAcesso {
    
    @Autowired
    private Fachada fachada;

    
    
    @RequestMapping("/gerar")
    public ResponseEntity<?> gerarLogAcesso(@RequestBody LogAcesso logAcesso) {
        System.out.println(logAcesso.getDiaAcesso());
        try {
            this.fachada.gerarLogAcesso(logAcesso);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @RequestMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogAcesso> listarLogsAcesso() {
        List<LogAcesso> logsAcesso = null;
        try {
            logsAcesso = this.fachada.listarLogsAcesso();
        } catch (ExceptionLogAcessoLeitura ex) {
            Logger.getLogger(ControllerLogAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logsAcesso;
    }
    
    @RequestMapping(value = "/filtrarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogAcesso> filtrarLogAcessoCodigoUsuario(@RequestParam Long codigoUsuario) {
        List<LogAcesso> logsAcesso = null;
        try {
            logsAcesso = this.fachada.filtrarLogAcessoCodigoUsuario(codigoUsuario);
        } catch (ExceptionLogAcessoLeitura ex) {
            Logger.getLogger(ControllerLogAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logsAcesso;
    }
    
    @RequestMapping(value = "/filtrarDataAndHora", produces = MediaType.APPLICATION_JSON_VALUE)
    public LogAcesso filtrarLogAcessoDateAndHora(@RequestParam Date diaAcesso, @RequestParam Date horaAcesso) {
        LogAcesso logsAcesso = null;
        try {
            logsAcesso = this.fachada.filtrarLogAcessoDataAndHoraAcesso(diaAcesso, horaAcesso);
        } catch (ExceptionLogAcessoLeitura ex) {
            Logger.getLogger(ControllerLogAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logsAcesso;
    }
    
    @RequestMapping(value = "/filtrarData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogAcesso> filtrarLogAcessoData(@RequestParam Date diaAcesso) {
        List<LogAcesso> logsAcesso = null;
        try {
            logsAcesso = this.fachada.filtrarLogAcessoData(diaAcesso);
        } catch (ExceptionLogAcessoLeitura ex) {
            Logger.getLogger(ControllerLogAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logsAcesso;
    }
    
    @RequestMapping(value = "/filtrarCodigo", produces = MediaType.APPLICATION_JSON_VALUE)
    public LogAcesso filtrarLogAcessoCodigo(@RequestParam int codigoLogAcesso) {
        LogAcesso logsAcesso = null;
        try {
            logsAcesso = this.fachada.filtrarLogAcessoCodigo(codigoLogAcesso);
        } catch (ExceptionLogAcessoLeitura ex) {
            Logger.getLogger(ControllerLogAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logsAcesso;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

}
