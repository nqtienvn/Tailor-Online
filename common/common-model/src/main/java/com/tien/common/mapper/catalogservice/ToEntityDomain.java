package com.tien.common.mapper.catalogservice;

import java.util.List;
/**
 * Interface dùng để map giữa Entity và Domain model.
 * <p>
 * - Entity (E): thường là class tương ứng với bảng trong database (JPA, Hibernate, v.v).
 * - Domain (D): class dùng cho business logic hoặc layer trung gian (service, DTO, etc).
 */
public interface ToEntityDomain<E, D> {
    E toEntity(D domain);
    List<D> toDomain(List<E> entities);
    D toDomain(E entity);
}
