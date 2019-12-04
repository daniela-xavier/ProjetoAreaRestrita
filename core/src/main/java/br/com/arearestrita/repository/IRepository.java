package br.com.arearestrita.repository;

import br.com.arearestrita.model.DomainEntity;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRepository extends JpaRepository<DomainEntity, ID> {

    public List<DomainEntity> findByIncludedIn(Date includedIn);
    public List<DomainEntity> findByChangedIn(Date changedIn);

    public List<DomainEntity> findByIncludedBy(String includedBy);
    public List<DomainEntity> findByChangedBy(String changedBy);

    public List<DomainEntity> findByIncludedInAfter(Date includedIn);
    public List<DomainEntity> findByChangedInAfter(Date changedIn);

    public List<DomainEntity> findByIncludedInBefore(Date includedIn);
    public List<DomainEntity> findByChangedInBefore(Date changedIn);

    public List<DomainEntity> findByIncludedInAndIncludedBy(Date includedIn, String includedBy);
    public List<DomainEntity> findByChangedInAndChangedBy(Date changedIn, String changedBy);

    public List<DomainEntity> findByIncludedInBetween(final Date start, final Date end);
    public List<DomainEntity> findByChangedInBetween(final Date start, final Date end);

    public List<DomainEntity> findByIncludedByAndIncludedInBetween(String includedBy, final Date start, final Date end);
    public List<DomainEntity> findByChangedByAndChangedInBetween(String changedBy, final Date start, final Date end);

    public List<DomainEntity> findByActive(String active);
    public List<DomainEntity> findByActiveNot(String active);

    public List<DomainEntity> disable(String disable);

    public Optional<DomainEntity> findByFilter(DomainEntity entity);


}
