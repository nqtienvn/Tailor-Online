package com.tien.common.mapper.catalogservice;

public interface ToEntityDomain<E, D> {
    E toEntity(D domain);

    D toDomain(E entity);
}
