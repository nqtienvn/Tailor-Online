package com.tien.tai.infrastructure.persistence.repository.impl;

import com.tien.tai.domain.query.FabricSearchQuery;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import com.tien.tai.infrastructure.persistence.repository.FabricRepositoryCustom;
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
public class FabricRepositoryCustomImpl implements FabricRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public Long count(FabricSearchQuery params) {
        Map<String, Object> values = new HashMap<>();

        String whereClause = buildWhereClause(params, values);

        String jpql = "SELECT COUNT(c) FROM FabricEntity c " + whereClause;

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        values.forEach(query::setParameter); //set các du lieu vao :name, :delete,...

        return query.getSingleResult();
    }

    @Override
    public List<FabricEntity> search(FabricSearchQuery params) {
        Map<String, Object> values = new HashMap<>();
        String jpql = "SELECT DISTINCT(c) FROM FabricEntity c " + buildWhereClause(params, values) + createOrderQuery(params.getSortBy());
        Query query = entityManager.createQuery(jpql, FabricEntity.class);
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

    private String buildWhereClause(FabricSearchQuery params, Map<String, Object> values) {
        StringBuilder where = new StringBuilder("WHERE 1=1 "); //cau điều kiện true để không có điều kiện nào thì quẻy vẫn hoạt động

        if (params.getIsDeleted() == null || !params.getIsDeleted()) {
            where.append("AND c.isDeleted = FALSE ");
        } else where.append("AND c.isDeleted = TRUE ");
        if (params.getStatus() != null && !params.getStatus()) {
            where.append("AND c.status = FALSE ");
        }
        if (Boolean.TRUE.equals(params.getStatus())) where.append("AND c.status = TRUE ");

        if (params.getName() != null && !params.getName().isBlank()) {
            where.append("AND LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) ");
            values.put("name", params.getName());
        }
        if (params.getColor() != null && !params.getColor().isBlank()) {
            where.append("AND LOWER(c.color) = LOWER(:color) ");
            values.put("color", params.getColor());
        }

        return where.toString();
    }
}
