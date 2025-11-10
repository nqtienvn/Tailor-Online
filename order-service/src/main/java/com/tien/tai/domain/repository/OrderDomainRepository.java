package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.domain.model.OrderDomain;
import jakarta.persistence.criteria.Order;

public interface OrderDomainRepository extends DomainRepositoryCommon<OrderDomain, Integer> {
}
