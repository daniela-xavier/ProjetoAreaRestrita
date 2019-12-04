package br.com.arearestrita.repository.impl;

import br.com.arearestrita.model.DomainEntity;
import br.com.arearestrita.repository.IRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component("entityRepository")
public class DomainEntityRepository implements IRepository {


    @Override
    public List<DomainEntity> findByIncludedIn(Date includedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedIn(Date changedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedBy(String includedBy) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedBy(String changedBy) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedInAfter(Date includedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedInAfter(Date changedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedInBefore(Date includedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedInBefore(Date changedIn) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedInAndIncludedBy(Date includedIn, String includedBy) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedInAndChangedBy(Date changedIn, String changedBy) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedInBetween(Date start, Date end) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedInBetween(Date start, Date end) {
        return null;
    }

    @Override
    public List<DomainEntity> findByIncludedByAndIncludedInBetween(String includedBy, Date start, Date end) {
        return null;
    }

    @Override
    public List<DomainEntity> findByChangedByAndChangedInBetween(String changedBy, Date start, Date end) {
        return null;
    }

    @Override
    public List<DomainEntity> findByActive(String active) {
        return null;
    }

    @Override
    public List<DomainEntity> findByActiveNot(String active) {
        return null;
    }

    @Override
    public List<DomainEntity> disable(String disable) {
        return null;
    }

    @Override
    public Optional<DomainEntity> findByFilter(DomainEntity entity) {
        return Optional.empty();
    }

    @Override
    public List<DomainEntity> findAll() {
        return null;
    }

    @Override
    public List<DomainEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DomainEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<DomainEntity> findAllById(Iterable<ID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void delete(DomainEntity entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends DomainEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends DomainEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends DomainEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<DomainEntity> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends DomainEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<DomainEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DomainEntity getOne(ID id) {
        return null;
    }

    @Override
    public <S extends DomainEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DomainEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DomainEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DomainEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DomainEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DomainEntity> boolean exists(Example<S> example) {
        return false;
    }
}