package com.tien.common.domain.repository;

public interface CatalogDomainRepositoryCommon<T, I> {
    T save(T domain);

    T findById(I id);

    void softDelete(T domain);

    void saveStatus(T domain);
}
