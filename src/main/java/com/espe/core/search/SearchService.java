package com.espe.core.search;

import com.espe.infrastructure.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService <T, ID> {
    public  T byId(JpaRepository<T, ID> repository, ID id) {
        String message = "Id no found " + id;
        return byId(repository, id, message);
    }

    public T byId(JpaRepository<T, ID> repository, ID id, String msg) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(msg));
    }
}
