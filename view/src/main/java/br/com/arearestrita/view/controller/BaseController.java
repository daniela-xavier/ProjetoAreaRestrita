package br.com.arearestrita.view.controller;

import br.com.arearestrita.aplicacao.EntityApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description the class  BaseController - Classe base para as requisiçães do
 * WebService.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BaseController extends EntityApplication {
}
