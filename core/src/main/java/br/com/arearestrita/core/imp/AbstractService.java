package br.com.arearestrita.core.imp;

import br.com.arearestrita.model.anotations.ADomainEntity;

/**
 * Description the class  AbstractService - Classe que implementa o retorno dos
 * atributos da anotação @ADomainEntity
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public abstract class AbstractService {

    /**
     * Método que recupera a classe de DomainEntity -> Service.class instanciada.
     *
     * @return Classe DomainEntity
     */
    public Class<?> getClasse() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.classe();
        }

        return null;
    }

    /**
     * Método que recupera o nome da entidade de  DomainEntity Service.class
     * instanciada.
     *
     * @return  DomainEntity
     */
    public String getEntidadeNome() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.nome();
        }

        return null;
    }

}

