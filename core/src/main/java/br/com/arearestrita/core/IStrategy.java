package br.com.arearestrita.core;


import br.com.arearestrita.model.DomainEntity;

public interface IStrategy {

    /**
     * Método que realiza o process do método strategy.
     * @param entity
     * @return String
     */
    public String process(DomainEntity entity);
}