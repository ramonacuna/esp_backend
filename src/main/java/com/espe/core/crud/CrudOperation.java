package com.espe.core.crud;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface CrudOperation <T, ID> {
    Long RegistriesAmount();
    List<T> getAll(Sort sort);
    T add(T entity);
    List<T> addAll(List<T> entities);
    T searchById(ID id);
    T searchById(ID id, String msg);
    boolean delete(ID id);
    T update(T myEntity);
}
