package br.com.arearestrita.model.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description the class  ADomainEntity - Classe que contém a anotação para as services de entidades.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ADomainEntity {

    /**
     * Atributo de nome da entidade.
     * @return nome
     */
    String nome();
    
    /**
     * Retorna a classe da entidade.
     * @return Class Entity
     */
    Class<?> classe();
}

