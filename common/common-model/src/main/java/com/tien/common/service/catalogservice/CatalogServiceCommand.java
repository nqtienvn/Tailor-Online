package com.tien.common.service.catalogservice;

public interface CatalogServiceCommand<T, F, I> {
    T create(F request);

    T update(F request, I id);

    void softDelete(I id);

    void inActive(I id);

    void active(I id);
}
