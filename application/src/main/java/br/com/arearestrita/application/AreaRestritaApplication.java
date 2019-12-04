package br.com.arearestrita.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.arearestrita.*" })
public class AreaRestritaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AreaRestritaApplication.class, args);
    }

}
