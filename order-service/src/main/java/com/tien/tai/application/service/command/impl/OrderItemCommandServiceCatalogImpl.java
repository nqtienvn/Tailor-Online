package com.tien.tai.application.service.command.impl;

import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.OrderItemMapperDTO;
import com.tien.tai.application.dto.request.OrderItemRequest;
import com.tien.tai.application.dto.request.OrderRequest;
import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.application.mapper.OrderItemCommandMapper;
import com.tien.tai.domain.command.OrderItemCmd;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.model.OrderItemDomain;
import com.tien.tai.domain.repository.OrderItemDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<OrderItemDTO, OrderItemRequest,Integer> {
    private final OrderItemCommandMapper commandMapper;
    private final OrderItemMapperDTO mapperDTO;
    private final OrderItemDomainRepository domainRepository;

    @Override
    public OrderItemDTO create(OrderItemRequest request) {
        OrderItemDomain orderItemDomain = new OrderItemDomain(commandMapper.form(request));

        return mapperDTO.form(domainRepository.save(orderItemDomain));
    }

    @Override
    public OrderItemDTO update(OrderItemRequest request, Integer id) {
        OrderItemCmd orderItemCmd = commandMapper.form(request);
        OrderItemDomain orderItemDomain = domainRepository.findById(id);
        orderItemDomain.update(orderItemCmd);
        return mapperDTO.form(domainRepository.save(orderItemDomain));
    }

    @Override
    public OrderItemDTO detail(Integer id) {
        return mapperDTO.form(domainRepository.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        OrderItemDomain findByID = domainRepository.findById(id);
        findByID.softDelete();
        domainRepository.softDelete(findByID);

    }

    @Override
    public void inActive(Integer id) {
        OrderItemDomain findByID = domainRepository.findById(id);
        findByID.inActive();
        domainRepository.save(findByID);

    }

    @Override
    public void active(Integer id) {
        OrderItemDomain findByID = domainRepository.findById(id);
        findByID.active();
        domainRepository.save(findByID);
    }
}
