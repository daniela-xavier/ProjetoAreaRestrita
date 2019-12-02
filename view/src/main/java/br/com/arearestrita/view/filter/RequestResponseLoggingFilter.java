package br.com.arearestrita.view.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description the class  RequestResponseLoggingFilter - xxxxx
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {
   /**
     * Logging todo o request da aplica��o para auditoria
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    
    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOGGER.info(
          "Logging Request  {} : {}", req.getMethod(), 
          req.getRequestURI());
        chain.doFilter(request, response);
        LOGGER.info(
          "Logging Response :{}", 
          res.getContentType());
    }
 
    /**
     *
     * @param fc
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig fc) throws ServletException {
         LOGGER.info("Init filtro de RequestResponse");
    }

    /**
     * Destroi filtro de request response.
     */
    @Override
    public void destroy() {       
        LOGGER.warn("Destroy filtro de RequestResponse");
    }
}
