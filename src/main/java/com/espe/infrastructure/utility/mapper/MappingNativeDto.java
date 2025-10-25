package com.espe.infrastructure.utility.mapper;

import jakarta.persistence.Tuple;

public interface MappingNativeDto <D>{
    D mappingFromTuple(Tuple myTuple);
}
