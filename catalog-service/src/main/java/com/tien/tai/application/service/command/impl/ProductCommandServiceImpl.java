package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.CatalogDomainRepositoryCommon;
import com.tien.common.service.catalogservice.ServiceCatalogCommon;
import com.tien.tai.application.dto.mapper.ProductMapperDTO;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.application.mapper.ProductCommandMapper;
import com.tien.tai.domain.model.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ServiceCatalogCommon<ProductResponse, ProductRequest, Integer> {
    private final ProductCommandMapper productCommandMapper;
    private final CatalogDomainRepositoryCommon<ProductDomain, Integer> catalogDomainRepositoryCommon;
    private final ProductMapperDTO productMapperDTO;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        ProductDomain create = new ProductDomain(productCommandMapper.from(productRequest));
        return productMapperDTO.from(catalogDomainRepositoryCommon.save(create));
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, Integer id) {
        return null;
    }

    @Override
    public void softDelete(Integer id) {

    }

    @Override
    public void inActive(Integer id) {

    }

    @Override
    public void active(Integer id) {

    }
}
