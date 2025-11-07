package com.tien.tai.infrastructure.persistence.repository.impl;

import com.tien.tai.domain.query.ProductSearchQuery;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import com.tien.tai.infrastructure.persistence.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public Long count(ProductSearchQuery params) {
        Map<String, Object> values = new HashMap<>();

        String whereClause = buildWhereClause(params, values);

        String jpql = "SELECT COUNT(c) FROM ProductEntity c " + whereClause;

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        values.forEach(query::setParameter); //set các du lieu vao :name, :delete,...

        return query.getSingleResult();
    }

    @Override
    public List<ProductEntity> search(ProductSearchQuery params) {
        Map<String, Object> values = new HashMap<>();
        String jpql = "SELECT DISTINCT(c) FROM ProductEntity c " + buildWhereClause(params, values) + createOrderQuery(params.getSortBy());
        Query query = entityManager.createQuery(jpql, ProductEntity.class);
        values.forEach(query::setParameter);
        query.setFirstResult((params.getPageIndex() - 1) * params.getPageSize()); //offset
        query.setMaxResults(params.getPageSize());
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

    private String buildWhereClause(ProductSearchQuery params, Map<String, Object> values) {
        StringBuilder where = new StringBuilder("WHERE 1=1 "); //cau điều kiện true để không có điều kiện nào thì quẻy vẫn hoạt động

        if (params.getName() != null && !params.getName().isBlank()) {
            where.append("AND LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ");
            values.put("name", params.getName());
        }
        if (params.getCategoryId() != null) {
            where.append("AND c.categoryId = :categoryId ");
            values.put("categoryId", params.getCategoryId());
        }
        if (params.getFabricId() != null) {
            where.append("AND c.fabricId = :fabricId ");
            values.put("fabricId", params.getFabricId());
        }
        if (params.getBasePrice() != null) {
            where.append("AND c.basePrice = :basePrice ");
            values.put("basePrice", params.getBasePrice());
        }

        return where.toString();
    }
}
