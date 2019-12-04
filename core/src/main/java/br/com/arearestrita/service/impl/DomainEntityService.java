package br.com.arearestrita.service.impl;

import br.com.arearestrita.repository.IRepository;
import br.com.arearestrita.repository.impl.DomainEntityRepository;
import br.com.arearestrita.service.AbstractService;
import br.com.arearestrita.model.DomainEntity;
import br.com.arearestrita.model.anotations.ADomainEntity;
import br.com.arearestrita.service.IService;
import br.com.arearestrita.strategy.DomainEntityStrategy;
import br.com.arearestrita.strategy.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Component
@Service("entityService")
@ADomainEntity(nome = "DomainEntity", classe = DomainEntity.class)
public class DomainEntityService extends AbstractService implements IService {

    @Autowired
    @Qualifier(value = "entityRepository")
    DomainEntityRepository entityRepository;

    @Autowired
    @Qualifier(value = "entityStrategy")
    DomainEntityStrategy entityStrategy;

    /**
     *
     * @return IRepository
     */
    @Override
    public IRepository getRepository() {
        return entityRepository;
    }

    /**
     * Retorna regras da entidade.
     * @return Map String, List -> IStrategy
     */
    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return entityStrategy.getRnsEntity();
    }
}
