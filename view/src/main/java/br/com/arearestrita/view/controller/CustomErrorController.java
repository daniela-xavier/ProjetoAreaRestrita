package br.com.arearestrita.view.controller;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * Description the class CustomErrorController - xxxxx
 *
 * @author Daniela Xavier Concei��o - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${custom-error-controller.debug}")
    private boolean debug;

    /**
     * Bean para retorno de property Config In Dev.
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ResponseEntity<ErrorJson> error(WebRequest webRequest, HttpServletResponse response) {
        return ResponseEntity.status(response.getStatus())
                .body(
                        new ErrorJson(response.getStatus(), getErrorAttributes(webRequest, debug)
                        )
                );
    }

    /**
     * Retorna Erro path
     * @return string
     */
    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }
}
