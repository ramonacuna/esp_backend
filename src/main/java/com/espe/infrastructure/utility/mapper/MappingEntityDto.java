package com.espe.infrastructure.utility.mapper;

public interface MappingEntityDto <E,D> {
    D fromEntity(E myEntity);
    E fromDto(D myDto);
}
