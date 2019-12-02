package br.com.arearestrita.core;

import br.com.arearestrita.aplicacao.Result;
import br.com.arearestrita.model.DomainEntity;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Description the class br.com.arearestrita.core.IFachada - Classe de padronização para implementação de
 * padrão fachada.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */
@Component
public
interface IFacade {

    /**
     * Método que salva entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result save(DomainEntity entity, IService service);

    /**
     * Método que altera entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result update(DomainEntity entity, IService service);

    /**
     * Método que delete entity.
     *
     * @param id
     * @param service
     * @return Result
     */
    public Result delete(ID id, IService service);

    /**
     * Método que desativa entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result disable(DomainEntity entity, IService service);

    /**
     * Método que consulta entity.
     *
     * @param classe
     * @param service
     * @return Result
     */
    public Result findAll(Class classe, IService service, Pageable pageable);
    /**
     * Método que consulta entity.
     *
     * @param id
     * @param service
     * @return Result
     */
    public Result findById(ID id, IService service);
    /**
     * Método que consulta entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result FindByFilter(DomainEntity entity, IService service);


    /**
     * Método que visualiza entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result view(DomainEntity entity, IService service);

}

