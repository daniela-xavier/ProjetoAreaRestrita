package br.com.arearestrita.view.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description the class RestartController - xxxxx
 *
 * @author Daniela Xavier Concei��o - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@RestController
public class IndexController {

    /**
    * Método para requisiçães GET na raiz do projeto.
    *
    * @return String
    */
    @GetMapping("/foz")
    @ApiOperation(value="Index da aplicacao")
    public String index() {
        return "Bem vindo(a) ao WebServiceFoz"
                + "\t Documentacao do projeto: " + "http://path/swagger-ui.html";
    }


}