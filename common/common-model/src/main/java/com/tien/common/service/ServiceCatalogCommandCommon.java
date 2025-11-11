package com.tien.common.service;
/**
 * Generic command service interface for CRUD operations.
 * @param <T> DTO type
 * @param <F> Request type
 * @param <I> ID type
 */
public interface ServiceCatalogCommandCommon<T, F, I> {
    T create(F request);

    T update(F request, I id);

    T detail(I id);

    void softDelete(I id);

    void inActive(I id);

    void active(I id);
}
