package com.tien.common.domain.repository;
/**
 * Common domain repository interface defining basic persistence operations
 * for domain models in the application.
 *
 * @param <T> Domain model type
 * @param <I> ID type used to identify the domain
 */
public interface DomainRepositoryCommon<T, I> {
    T save(T domain);

    T findById(I id);

    void softDelete(T domain);

    void saveStatus(T domain);
}
