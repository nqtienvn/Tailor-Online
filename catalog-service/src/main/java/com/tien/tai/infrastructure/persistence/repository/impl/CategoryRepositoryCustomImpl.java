package com.tien.tai.infrastructure.persistence.repository.impl;

import com.tien.tai.domain.query.CategorySearchQuery;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long count(CategorySearchQuery params) {
        Map<String, Object> values = new HashMap<>();

        String whereClause = buildWhereClause(params, values);

        String jpql = "SELECT COUNT(c) FROM CategoryEntity c " + whereClause;

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        values.forEach(query::setParameter); //set các du lieu vao :name, :delete,...

        return query.getSingleResult();
    }

    @Override
    public List<CategoryEntity> search(CategorySearchQuery searchQuery) {
        Map<String, Object> values = new HashMap<>();
        String jpql =
                "SELECT DISTINCT(c) FROM CategoryEntity c "
                        + buildWhereClause(searchQuery, values)
                        + createOrderQuery(searchQuery.getSortBy());
        Query query = entityManager.createQuery(jpql, CategoryEntity.class);
        values.forEach(query::setParameter);
        query.setFirstResult((searchQuery.getPageIndex() - 1) * searchQuery.getPageSize()); //offset
        query.setMaxResults(searchQuery.getPageSize());
        return query.getResultList();
    }

    public StringBuilder createOrderQuery(String sortBy) {
        StringBuilder hql = new StringBuilder(" ");
        if (StringUtils.hasLength(sortBy)) {
            hql.append(" ORDER BY c.").append(sortBy.replace(".", " "));
        } else {
            hql.append(" ORDER BY c.modifiedDate DESC");
        }
        return hql;
    }

    private String buildWhereClause(CategorySearchQuery params, Map<String, Object> values) {
        StringBuilder where = new StringBuilder("WHERE 1=1 "); //cau điều kiện true để không có điều kiện nào thì quẻy vẫn hoạt động

        if (params.getIsDeleted() == null || !params.getIsDeleted()) {
            where.append("AND c.isDeleted = FALSE ");
        } else where.append("AND c.isDeleted = TRUE ");

        if (params.getName() != null && !params.getName().isBlank()) {
            where.append("AND LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ");
            values .put("name", params.getName());
        }

        return where.toString();
    }
}
