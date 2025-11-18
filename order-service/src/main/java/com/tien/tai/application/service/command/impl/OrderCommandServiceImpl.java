package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.mapper.OrderMapperDTO;
import com.tien.tai.application.dto.request.OrderCreateRequest;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.application.mapper.OrderCommandMapper;
import com.tien.tai.domain.command.OrderCmd;
import com.tien.tai.domain.model.OrderDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements ServiceCommandCommon<OrderDTO, OrderCreateRequest, Integer> {
    private final OrderCommandMapper orderCommandMapper;
    private final OrderMapperDTO orderMapperDTO;
    private final DomainRepositoryCommon<OrderDomain, Integer> domainRepository;

    @Override
    public OrderDTO create(OrderCreateRequest request) {
        OrderDomain orderDomain = new OrderDomain(orderCommandMapper.from(request));
        return  orderMapperDTO.form(domainRepository.save(orderDomain));
    }

    @Override
    public OrderDTO update(OrderCreateRequest request, Integer id) {
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
