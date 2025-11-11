package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.model.OrderItemDomain;
import com.tien.tai.domain.repository.OrderItemDomainRepository;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import com.tien.tai.infrastructure.persistence.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderItemDomainRepositoryImpl implements OrderItemDomainRepository {
    private final OrderItemRepository orderItemRepository;
    private final  ToEntityDomain<OrderItemEntity,OrderItemDomain> toEntityDomain;



    @Override
    public OrderItemDomain save(OrderItemDomain domain) {
        try {
            OrderItemEntity entity = toEntityDomain.toEntity(domain);
            OrderItemEntity savedEntity = orderItemRepository.save(entity);

            if (savedEntity == null || savedEntity.getId() == null) {
                throw new RuntimeException("Failed to save OrderItemEntity: repository returned null or invalid ID");
            }

            return toEntityDomain.toDomain(savedEntity);

        } catch (DataAccessException ex) {
            log.error("Database error while saving OrderItemEntity: {}", ex.getMessage(), ex);
            throw new RuntimeException("Database error while saving order item", ex);
        } catch (Exception ex) {
            log.error("Unexpected error while saving OrderItemEntity: {}", ex.getMessage(), ex);
            throw new RuntimeException("Unexpected error while saving order item", ex);
        }
    }

    @Override
    public OrderItemDomain findById(Integer id) {
        return toEntityDomain.toDomain(orderItemRepository.findById(id).
                orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(OrderItemDomain domain) {
        orderItemRepository.save(toEntityDomain.toEntity(domain));

    }

    @Override
    public void saveStatus(OrderItemDomain domain) {
        orderItemRepository.save(toEntityDomain.toEntity(domain));
    }
}
