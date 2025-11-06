package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.CatalogDomainRepositoryCommon;
import com.tien.common.service.catalogservice.CatalogServiceCommand;
import com.tien.tai.application.dto.mapper.ProductMapperDTO;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.application.mapper.ProductCommandMapper;
import com.tien.tai.domain.model.ProductDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandImpl implements CatalogServiceCommand<ProductResponse, ProductRequest, Integer> {
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
        ProductDomain findProduct = catalogDomainRepositoryCommon.findById(id);
        findProduct.update(productCommandMapper.from(productRequest));
        return productMapperDTO.from(catalogDomainRepositoryCommon.save(findProduct));
    }

    @Override
    public void softDelete(Integer id) {
        ProductDomain findProduct = catalogDomainRepositoryCommon.findById(id);
        findProduct.softDelete();
        catalogDomainRepositoryCommon.softDelete(findProduct);
    }

    @Override
    public void inActive(Integer id) {
        ProductDomain findProduct = catalogDomainRepositoryCommon.findById(id);
        findProduct.inActive();
        catalogDomainRepositoryCommon.saveStatus(findProduct);
    }

    @Override
    public void active(Integer id) {
        ProductDomain findProduct = catalogDomainRepositoryCommon.findById(id);
        findProduct.active();
        catalogDomainRepositoryCommon.saveStatus(findProduct);
    }
}
