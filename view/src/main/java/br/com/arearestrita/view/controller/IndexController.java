package br.com.arearestrita.view.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description the class RestartController - xxxxx
 *
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
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
    @ApiOperation(value = "Index da aplicacao")
    public String index() {
        return "Bem vindo(a) ao WebServiceFoz"
                + "\t Documentacao do projeto: " + "http://path/swagger-ui.html";
    }

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }

    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page!!");
        return "next";
    }


}
