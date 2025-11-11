package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.domain.model.OrderDomain;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderDomainRepository extends DomainRepositoryCommon<OrderDomain, Integer> {
    void enrichDTO (List<OrderDTO> orderDTOList);
}
