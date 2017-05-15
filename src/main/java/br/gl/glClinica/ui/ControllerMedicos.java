
package br.gl.glClinica.ui;

import br.gl.glClinica.regraNegocio.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
