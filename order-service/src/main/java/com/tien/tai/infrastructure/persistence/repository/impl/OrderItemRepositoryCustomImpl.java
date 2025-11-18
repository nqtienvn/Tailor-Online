//package com.tien.tai.infrastructure.persistence.repository.impl;
//
//import com.tien.common.query.QueryUtils;
//import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
//import com.tien.tai.infrastructure.persistence.repository.OrderItemRepositoryCustom;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.TypedQuery;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class OrderItemRepositoryCustomImpl implements OrderItemRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Override
//    public Long count(OrderItemSearchQuery params) {
//        Map <String,Object> values = new HashMap<>();
//        String whereClause = buildWhereClause(params,values);
//        String jqpl = "SELECT COUNT (c) FROM OrderItemEntity c " + whereClause;
//        TypedQuery<Long> query = entityManager.createQuery(jqpl, Long.class);
//        values.forEach(query::setParameter);
//        return query.getSingleResult();
//    }
//
//
//    @Override
//    public List<OrderItemEntity> search(OrderItemSearchQuery params) {
//        Map<String,Object> values = new HashMap<>();
//        String jpql = "SELECT DISTINCT (c) FROM OrderItemEntity c "
//                +buildWhereClause(params,values)
//                + QueryUtils.createOrderQuery(params.getSortBy());
//        TypedQuery<OrderItemEntity> query = entityManager.createQuery(jpql,OrderItemEntity.class);
//        values.forEach(query::setParameter);
//        query.setFirstResult((params.getPageIndex() - 1) * params.getPageSize());
//        query.setMaxResults(params.getPageSize());
//        return query.getResultList();
//
//    }
//
//    private String buildWhereClause(OrderItemSearchQuery params, Map<String, Object> values) {
//        StringBuilder where = new StringBuilder("WHERE 1=1");
//        if (params.getIsDeleted() != null) {
//            where.append("And c.isDeleted = :isDeleted");
//            values.put("isDeleted", params.getIsDeleted());
//        }
//        if (params.getQuantityFrom() != null){
//            where.append("And c.quantity >= :quantityFrom");
//            values.put("quantityFrom",params.getQuantityFrom());
//        }
//        if (params.getQuantityTo() != null){
//            where.append("And c.quantity <= :quantityTo");
//            values.put("quantityTo",params.getQuantityFrom());
//        }
//        if (params.getSubtotalFrom() != null){
//            where.append("And c.subtotal >= :subtotalFrom");
//            values.put("subtotalFrom",params.getSubtotalFrom());
//        }
//        if (params.getSubtotalTo() != null) {
//            where.append("And c.subtotal <= :subtotalTo");
//            values.put("subtotalTo", params.getSubtotalTo());
//        }
//        if (params.getStatus() != null) {
//            where.append("AND LOWER(c.status LIKE LOWER (:status))");
//            values.put("status",params.getStatus());
//        }
//        if (params.getFabricType() != null) {
//            where.append("AND LOWER(c.fabricType LIKE LOWER (:fabricType))");
//            values.put("fabricType",params.getFabricType());
//        }
//        if (params.getOrderId() != null){
//            where.append("And c.orderId = :orderId");
//            values.put("orderId", params.getOrderId());
//        }
//        return where.toString();
//    }
//}
