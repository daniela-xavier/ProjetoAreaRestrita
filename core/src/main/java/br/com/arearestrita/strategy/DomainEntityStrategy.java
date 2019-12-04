package br.com.arearestrita.strategy;

import br.com.arearestrita.strategy.impl.DisableAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("entityStrategy")
public class DomainEntityStrategy {

    Map<String, List<IStrategy>> rnsEntity = new HashMap<>();

    /**
     * Contrutor da classe para inicializar as strategys.
     *
     * @param disableAction - Strategy que desabilita a operação.
     *
     */
    @Autowired
    public DomainEntityStrategy(
            DisableAction disableAction
    ) {

        //Regras para entidade Entity passadas dentro do construtor 
        //Injetadas pelo Spring com a anotação @Autowired

        /* Criando uma lista para conter as regras de negocio de Entity
         * quando a operacao for salvar
         */
        final List<IStrategy> rnsSalvarEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do Entity */

        rnsSalvarEntity.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de Entity
         * quando a operacao for alterar
         */
        final List<IStrategy> rnsAlterarEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do Entity */
        rnsAlterarEntity.add(disableAction);


        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for alterar
         */
        final List<IStrategy> rnsConsultarEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao consultar do Entity */
        rnsConsultarEntity.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for excluir
         */
        final List<IStrategy> rnsExcluirEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao excluir do Entity */
        rnsExcluirEntity.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for visualizar
         */
        final List<IStrategy> rnsVisualizarEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao visualizar do Entity */
        rnsVisualizarEntity.add(disableAction);

        /* Criando uma lista para conter as regras de negocio de act
         * quando a operacao for desativar
         */
        final List<IStrategy> rnsDesativarEntity = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao desativar do Entity */
        rnsDesativarEntity.add(disableAction);

        /*
         * Adiciona a listra de regras na operacao salvar no mapa do Entity
         */
        rnsEntity.put("SALVAR", rnsSalvarEntity);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Entity
         */
        rnsEntity.put("ALTERAR", rnsAlterarEntity);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Entity
         */
        rnsEntity.put("CONSULTAR", rnsConsultarEntity);
        /*
         * Adiciona a listra de regras na operacao excluir no mapa do Entity
         */
        rnsEntity.put("EXCLUIR", rnsExcluirEntity);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do Entity
         */
        rnsEntity.put("VISUALIZAR", rnsVisualizarEntity);
        /*
         * Adiciona a listra de regras na operacao desativar no mapa do Entity
         */
        rnsEntity.put("DESATIVAR", rnsVisualizarEntity);

    }

    /**
     * Retorna regras da entidade.
     *
     * @return Map String, List -> IStrategy
     */
    public Map<String, List<IStrategy>> getRnsEntity() {
        return rnsEntity;
    }
}
