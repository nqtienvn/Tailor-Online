//package com.tien.tai.infrastructure.persistence.repository.impl;
//
//import com.tien.common.query.QueryUtils;
//import com.tien.tai.infrastructure.persistence.model.OrderEntity;
//import com.tien.tai.infrastructure.persistence.repository.OrderRepositoryCustom;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.TypedQuery;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Long count(OrderSeachQuery params) {
//        Map <String,Object> values = new HashMap<>();
//        String whereClause = buildWhereClause(params,values);
//        String jpql = "SELECT COUNT(c) FROM OrderEntity c " + whereClause;
//
//       TypedQuery <Long> query = entityManager.createQuery(jpql,Long.class);
//
//       values.forEach(query :: setParameter);
//       return query.getSingleResult();
//    }
//
//
//    @Override
//    public List<OrderEntity> search(OrderSeachQuery params) {
//        Map <String,Object> values = new HashMap<>();
//        String jpql = "SELECT DISTINCT (c) FROM OrderEntity c"
//                + buildWhereClause(params,values)
//                + QueryUtils.createOrderQuery(params.getSortBy());
//        TypedQuery<OrderEntity> query = entityManager.createQuery(jpql,OrderEntity.class);
//        values.forEach(query::setParameter);
//        query.setFirstResult((params.getPageIndex() - 1) * params.getPageSize());
//        query.setMaxResults(params.getPageSize());
//        return query.getResultList();
//    }
//
//
//
//    private String buildWhereClause(OrderSeachQuery params, Map<String, Object> values) {
//        StringBuilder where = new StringBuilder("WHERE 1=1");
//        if (params.getIsDeleted() != null) {
//            where.append("And c.isDeleted =: isDeleted");
//            values.put("isDeleted", params.getIsDeleted());
//        }
//        if (params.getCustomerName() != null) {
//            where.append("AND LOWER(c.customerName LIKE LOWER (:customerName))");
//            values.put("customerName",params.getCustomerName());
//        }
//        if (params.getPhone() != null) {
//            where.append("And c.phone =: phone");
//            values.put("phone", params.getPhone());
//        }
//        if (params.getAddress() != null) {
//            where.append("AND LOWER(c.address LIKE LOWER (:address))");
//            values.put("address",params.getAddress());
//        }
//        if (params.getStatus() != null) {
//            where.append("AND LOWER(c.status LIKE LOWER (:status))");
//            values.put("status",params.getStatus());
//        }
//        if (params.getOrderDateFrom() != null){
//            where.append("AND c.orderDate >= :orderDateFrom");
//            values.put("orderDateFrom",params.getOrderDateFrom());
//        }
//        if (params.getOrderDateTo() != null){
//            where.append("AND c.orderDate <= :orderDateTo");
//            values.put("orderDateTo",params.getOrderDateTo());
//        }
//        if (params.getCompletedDateFrom() != null){
//            where.append("AND c.completedDate >= :completedDateFrom");
//            values.put("completedDateFrom",params.getCompletedDateFrom());
//        }
//        if (params.getCompletedDateTo() != null){
//            where.append("AND c.completedDate <= :completedDateTo");
//            values.put("completedDateTo",params.getCompletedDateTo());
//        }
//        return where.toString();
//
//    }
//}
//
//
//
