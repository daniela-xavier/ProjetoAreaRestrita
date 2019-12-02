package br.com.arearestrita.core;


import br.com.arearestrita.model.DomainEntity;

public interface IStrategy {

    /**
     * Método que realiza o process do método strategy.
     * @param entidade
     * @return String
     */
    public String process(DomainEntity entidade);
}