package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.OrderMapperDTO;
import com.tien.tai.application.dto.request.OrderRequest;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.application.mapper.OrderCommandMapper;
import com.tien.tai.domain.command.OrderCmd;
import com.tien.tai.domain.model.OrderDomain;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandServiceCatalogImpl implements ServiceCatalogCommandCommon <OrderDTO, OrderRequest , Integer> {
    private final OrderCommandMapper orderCommandMapper;
    private final OrderMapperDTO orderMapperDTO;
    private final DomainRepositoryCommon<OrderDomain, Integer> domainRepository;

    @Override
    public OrderDTO create(OrderRequest request) {
        OrderDomain orderDomain = new OrderDomain(orderCommandMapper.from(request));
        return  orderMapperDTO.form(domainRepository.save(orderDomain));
    }

    @Override
    public OrderDTO update(OrderRequest request, Integer id) {
        OrderCmd orderCmd = orderCommandMapper.from(request);
        OrderDomain orderDomain = domainRepository.findById(id);
        orderDomain.update(orderCmd);
        return  orderMapperDTO.form(domainRepository.save(orderDomain));
    }

    @Override
    public OrderDTO detail(Integer id) {
        return orderMapperDTO.form(domainRepository.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        OrderDomain orderDomain = domainRepository.findById(id);
        orderDomain.softDelete();
        domainRepository.softDelete(orderDomain);
    }

    @Override
    public void inActive(Integer id) {

    }

    @Override
    public void active(Integer id) {

    }
}
