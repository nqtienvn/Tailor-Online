package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCommandCommon;
import com.tien.tai.application.dto.mapper.ProductMapperDTO;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.application.mapper.ProductCommandMapper;
import com.tien.tai.domain.model.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandImpl implements ServiceCommandCommon<ProductResponse, ProductRequest, Integer> {
    private final ProductCommandMapper productCommandMapper;
    private final DomainRepositoryCommon<ProductDomain, Integer> domainRepositoryCommon;
    private final ProductMapperDTO productMapperDTO;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        ProductDomain create = new ProductDomain(productCommandMapper.from(productRequest));
        return productMapperDTO.from(domainRepositoryCommon.save(create));
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, Integer id) {
        ProductDomain findProduct = domainRepositoryCommon.findById(id);
        findProduct.update(productCommandMapper.from(productRequest));
        return productMapperDTO.from(domainRepositoryCommon.save(findProduct));
    }

    @Override
    public void softDelete(Integer id) {
        ProductDomain findProduct = domainRepositoryCommon.findById(id);
        findProduct.softDelete();
        domainRepositoryCommon.softDelete(findProduct);
    }

    @Override
    public void inActive(Integer id) {
        ProductDomain findProduct = domainRepositoryCommon.findById(id);
        findProduct.inActive();
        domainRepositoryCommon.saveStatus(findProduct);
    }

    @Override
    public void active(Integer id) {
        ProductDomain findProduct = domainRepositoryCommon.findById(id);
        findProduct.active();
        domainRepositoryCommon.saveStatus(findProduct);
    }
}
