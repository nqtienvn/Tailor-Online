package com.tien.tai.application.service.query;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.mapper.OrderMapperDTO;
import com.tien.tai.application.dto.request.OrderSearchRequest;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.application.mapper.AutoMapperQuery;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.query.OrderSeachQuery;
import com.tien.tai.domain.repository.OrderDomainRepository;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.repository.OrderRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderQueryServiceImpl implements ServiceQueryCommon<PageDTO<OrderDTO>, OrderSearchRequest> {
    private final AutoMapperQuery autoMapperQueryl; //SearchRequest -> searchQuery
    private final ToEntityDomain<OrderEntity, OrderDomain> toEntityDomain; //entity <-> domain
    private final OrderMapperDTO orderMapperDTO; //Domain -> DTO
    private final OrderDomainRepository orderDomainRepository;
    private final OrderRepositoryCustom orderRepositoryCustom;

    @Override
    public PageDTO<OrderDTO> search(OrderSearchRequest request) {
        OrderSeachQuery orderSeachQuery = autoMapperQueryl.form(request);
        Long count = orderRepositoryCustom.count(orderSeachQuery);
        if (Objects.equals(count, 0L)) {
            return PageDTO.empty();
        }
        List<OrderDomain> orderDomainList = toEntityDomain.toDomain(orderRepositoryCustom.search(orderSeachQuery));
        List <OrderDTO> orderDTOList = orderMapperDTO.toDTO(orderDomainList);
        orderDomainRepository.enrichDTO(orderDTOList);
        return new PageDTO<>(orderDTOList, request.getPageIndex(), request.getPageSize(), count);
    }
}
