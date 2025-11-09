package com.tien.tai.infrastructor.persistence.repository.impl;

import com.tien.tai.domain.query.CustomerSearchQuery;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import com.tien.tai.infrastructor.persistence.repository.CustomerRepositoryCustomer;
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
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustomer {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long count(CustomerSearchQuery params) {
        Map<String, Object> values = new HashMap<>();

        String whereClause = buildWhereClause(params, values);

        String jpql = "SELECT COUNT(c) FROM CustomerEntity c " + whereClause;

        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

        values.forEach(query::setParameter); //set các du lieu vao :name, :delete,...

        return query.getSingleResult();
    }

    @Override
    public List<CustomerEntity> search(CustomerSearchQuery searchQuery) {
        Map<String, Object> values = new HashMap<>();
        String jpql =
                "SELECT DISTINCT(c) FROM CustomerEntity c "
                        + buildWhereClause(searchQuery, values)
                        + createOrderQuery(searchQuery.getSortBy());
        Query query = entityManager.createQuery(jpql, CustomerEntity.class);
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

    private String buildWhereClause(CustomerSearchQuery params, Map<String, Object> values) {
        StringBuilder where = new StringBuilder("WHERE 1=1 ");

        if (params.getIsTemporary() != null) {
            where.append("AND c.isTemporary = :isTemporary ");
            values.put("isTemporary", params.getIsTemporary());
        }
        if (params.getFullName() != null && !params.getFullName().isBlank()) {
            where.append("AND LOWER(c.fullName) LIKE LOWER(CONCAT('%', :fullName, '%')) ");
            values.put("fullName", params.getFullName());
        }
        if (params.getDateOfBirth() != null) {
            where.append("AND c.dateOfBirth = :dateOfBirth ");
            values.put("dateOfBirth", params.getDateOfBirth());
        }
        if (params.getGender() != null) {
            where.append("AND c.gender = :gender ");
            values.put("gender", params.getGender());
        }
        if (params.getPhoneNumber() != null && !params.getPhoneNumber().isBlank()) {
            where.append("AND c.phoneNumber = :phoneNumber ");
            values.put("phoneNumber", params.getPhoneNumber());
        }
        if (params.getEmail() != null && !params.getEmail().isBlank()) {
            where.append("AND LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%')) ");
            values.put("email", params.getEmail());
        }
        return where.toString();
    }

}
