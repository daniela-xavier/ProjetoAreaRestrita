package br.com.arearestrita.view.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description the class SwaggerConfig - xxxxx
 *
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Bean de configuracao do swagger 2.
     *
     * @return Docket
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    /**
     * Metodo de metainfo para swagger.
     *
     * @return ApiInfo
     */
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Área Restrita Foz REST",
                "Área restrista Foz Advogados. Sistema de acesso dos clientes para seus processos e andamentos.",
                "1.0",
                "Terms of Service",
                new Contact("Daniela Xavier Conceicao", "daniela.xavier.con@outlook.com.br", "sistemas@fozadvogados.com.br"),
                "License Version 2.0",
                "XXXXXX", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
