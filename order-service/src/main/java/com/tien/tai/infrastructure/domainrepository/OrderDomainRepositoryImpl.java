package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.repository.OrderDomainRepository;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderDomainRepositoryImpl implements OrderDomainRepository {
    private final OrderRepository orderRepository;
    private final ToEntityDomain<OrderEntity,OrderDomain> toEntityDomain;

    @Override
    public OrderDomain save(OrderDomain domain) {
        OrderEntity savedOrder = orderRepository.save(toEntityDomain.toEntity(domain));
        return toEntityDomain.toDomain(savedOrder);
    }

    @Override
    public OrderDomain findById(Integer id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() ->  new RuntimeException(new AppException(NotFoundError.NOT_FOUND)));
        return toEntityDomain.toDomain(orderEntity);
    }

    @Override
    public void softDelete(OrderDomain domain) {
        domain.softDelete();
        OrderEntity entity = toEntityDomain.toEntity(domain);
        orderRepository.save(entity);
    }

    @Override
    public void saveStatus(OrderDomain domain) {
        orderRepository.save(toEntityDomain.toEntity(domain));
    }
}
