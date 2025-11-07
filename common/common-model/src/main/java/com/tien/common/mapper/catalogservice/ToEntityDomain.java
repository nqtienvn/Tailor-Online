package com.tien.common.mapper.catalogservice;

import java.util.List;

public interface ToEntityDomain<E, D> {
    E toEntity(D domain);
    List<D> toDomain(List<E> entities);
    D toDomain(E entity);
}
