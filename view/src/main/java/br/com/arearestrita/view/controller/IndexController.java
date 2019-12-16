package br.com.arearestrita.view.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Description the class RestartController - xxxxx
 *
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 24/01/2019
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * Método para requisiçães GET na raiz do projeto.
     *
     * @return String
     */
    @GetMapping("/docs")
    @ApiOperation(value = "Index da documentação")
    public ModelAndView docs(HttpServletRequest request) {
        String urlSwagger = request.getContextPath() + "/swagger-ui.html";
        return new ModelAndView("redirect:" + urlSwagger);
    }

    @GetMapping("/")
    public String main(Model model) {
        return "logincliente";
    }

    @GetMapping("/paginaprincipal")
    public String home(Model model) {
        return "paginaprincipal";
    }

    @GetMapping("/esquecisenha")
    public String esquecisenha(Model model) { return "esquecisenha";}

    @GetMapping("/souclientefoz")
    public String soucliente(Model model) {
        return "souclientefoz";
    }

    @GetMapping("/souclientefozcontato")
    public String souclientefozcontato(Model model) { return "souclientefozcontato";}

    @GetMapping("/souclientefozendereco")
    public String souclientefozendereco(Model model) { return "souclientefozendereco";}

    @GetMapping("/confirmarcodigoacesso")
    public String confirmarcodigoacesso(Model model) { return "confirmarcodigoacesso";}

    @GetMapping("/atualizacaocadastral")
    public String atualizacaocadastral(Model model) { return "atualizacaocadastral";}


}
