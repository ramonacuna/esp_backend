package com.espe.core.crud;

import com.espe.core.search.SearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudOperationImpl <T, ID> implements CrudOperation<T,ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final SearchService<T, ID> searchService;

    protected CrudOperationImpl(SearchService<T, ID> searchService) {
        this.searchService = searchService;
    }

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public  Long RegistriesAmount() {
        return getRepository().count();
    }
    @Override
    public List<T> getAll(Sort sort) {
        return getRepository().findAll(sort);
    }
    @Override
    public T add(T entity) {
        return getRepository().save(entity);
    }
    @Override
    public List<T> addAll(List<T> entities) {
        return getRepository().saveAll(entities);
    }
    @Override
    public T searchById(ID id) {
        return searchService.byId(getRepository(), id);
    }
    @Override
    public T searchById(ID id, String msg) {
        return searchService.byId(getRepository(), id, msg);

    }
    @Override
    public boolean delete(ID id) {
        if(getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public T update(T myEntity) {
        return getRepository().save(myEntity);
    }
}
