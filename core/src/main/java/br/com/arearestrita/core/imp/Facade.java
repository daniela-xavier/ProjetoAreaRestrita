package br.com.arearestrita.core.imp;

import br.com.arearestrita.aplicacao.Result;
import br.com.arearestrita.core.IFacade;
import br.com.arearestrita.core.IService;
import br.com.arearestrita.core.IStrategy;
import br.com.arearestrita.model.DomainEntity;

import java.util.*;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Description the class Fachada - Classe que gerencia a execução de regras e
 * operações ao banco de acordo com a entidade passada por parametro.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */

@Component("facade")
public class Facade implements IFacade {

    private Result resultado;

    /**
     * Contrutor da classe.
     */
    public Facade() {
    }

    /**
     * Método que realiza as regras para a operação salvar para a entity passada
     * por parametro e metodo salvar do repositorio do serviço.
     *
     * @param entity
     * @param service
     * @return Result
     */
    @Override
    public Result save(DomainEntity entity, IService service) {

        resultado = new Result();

        String msg = process(entity, "SALVAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                service.getRepository().save(entity);
                Optional<DomainEntity> entities = Optional.of(entity);
                resultado.setEntity(entities);
                resultado.setMessage("Cadastro realizado com sucesso.");
            } catch (Exception e) {
                resultado.setError();
                System.out.println("Exception: " + e.toString() + " Message: " + e.getMessage());
                resultado.setMessage("Cadastro não realizado.");
            }
        }

        return resultado;
    }

    /**
     * Método que realiza as regras para a operação alterar para a entity
     * passada por parametro e metodo alterar do repositorio do serviço.
     *
     * @param entity
     * @param service
     * @return Result
     */
    @Override
    public Result update(DomainEntity entity, IService service) {

        resultado = new Result();

        String msg = process(entity, "ALTERAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                service.getRepository().save(entity);
                Optional<DomainEntity> entities = Optional.of(entity);
                resultado.setEntity(entities);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Método que realiza as regras para a operação deletar para a entity
     * passada por parametro e metodo deletar do repositorio do serviço.
     *
     * @param id
     * @param service
     * @return Result
     */
    @Override
    public Result delete(ID id, IService service) {

        resultado = new Result();

        DomainEntity entity = null;
        try {
            entity = (DomainEntity) service.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMessage("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }
        String msg = process(entity, "EXCLUIR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                service.getRepository().deleteById(id);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exclusão não executada, por gentileza verifique seus dados!");
                return resultado;
               // resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }finally {
                resultado.setMessage("Exclusão realizada com sucesso!");
            }
        }

        return resultado;
    }

    /**
     * Método que realiza as regras para a operação alterar para a entity
     * passada por parametro e metodo alterar do repositorio do serviço.
     *
     * @param entity
     * @param service
     * @return Result
     */
    @Override
    public Result disable(DomainEntity entity, IService service) {

        resultado = new Result();

        String msg = process(entity, "ALTERAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                service.getRepository().disable("N");
                Optional<DomainEntity> entities = Optional.of(entity);
                resultado.setEntity(entities);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar todos do repositorio do serviço.
     *
     * @param classe
     * @param service
     * @return Result
     */
    @Override
    public Result findAll(Class classe, IService service, Pageable pageable) {

        resultado = new Result();
        DomainEntity entity = null;
        try {
            entity = (DomainEntity) service.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMessage("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }

        String msg = process(entity, "CONSULTAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                Page<DomainEntity> pages = service.getRepository().findAll(pageable);

                if (pages == null) {
                    resultado.setMessage("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(pages.stream().findAny(),pages.getPageable());

            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;

    }

    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar por id do repositorio do
     * serviço.
     *
     * @param id
     * @param service
     * @return Result
     */
    @Override
    public Result findById(ID id, IService service) {
        resultado = new Result();

        DomainEntity entity = null;
        try {
            entity = (DomainEntity) service.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMessage("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }
        String msg = process(entity, "CONSULTAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                Optional<DomainEntity> entities = service.getRepository().findById(id);
                if (entities == null) {
                    resultado.setMessage("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(entities);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;

    }

    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar por filtro do repositorio do
     * serviço.
     *
     * @param entity
     * @param service
     * @return Result
     */
    @Override
    public Result FindByFilter(DomainEntity entity, IService service) {
        resultado = new Result();

        String msg = process(entity, "CONSULTAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            try {
                Optional<DomainEntity> findAll = service.getRepository().findByFilter(entity);
                if (findAll == null) {
                    resultado.setMessage("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(findAll);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMessage("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;
    }

    /**
     * Método que realiza as regras para a operação visualizar para a entity
     * passada por parametro.
     *
     * @param service
     * @return Result
     */
    @Override
    public Result view(DomainEntity entity, IService service) {
        resultado = new Result();
        String msg = process(entity, "VISUALIZAR", service.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMessage(msg);
        } else {
            Optional<DomainEntity> entities = Optional.of(entity);
            resultado.setEntity(entities);
        }
        return resultado;

    }

    /**
     * Método que executa as regras de acordo com a ação e entidade.
     *
     * @param entity
     * @param action
     * @param roles
     * @return String
     */
    private String process(DomainEntity entity, String action, Map<String, List<IStrategy>> roles) {

        StringBuilder msg = new StringBuilder();

        if (roles != null) {
            List<IStrategy> regras = roles.get(action);

            if (regras != null) {
                for (IStrategy s : regras) {

                    String m = s.process(entity);
                    if (m != null) {
                        // throw new RuntimeException("Não foi possivel realizar operação. Mensagem: " + m);
                        msg.append(m);
                        break;
                    }
                }
            }
        }

        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return null;
        }
    }

}

