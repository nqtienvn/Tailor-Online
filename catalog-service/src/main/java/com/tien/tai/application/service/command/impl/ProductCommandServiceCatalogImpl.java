package com.tien.tai.application.service.command.impl;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.service.ServiceCatalogCommandCommon;
import com.tien.tai.application.dto.mapper.ProductMapperDTO;
import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.application.mapper.ProductCommandMapper;
import com.tien.tai.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceCatalogImpl implements ServiceCatalogCommandCommon<ProductDTO, ProductRequest, Integer> {
    private final ProductCommandMapper productCommandMapper;
    private final DomainRepositoryCommon<Product, Integer> domainRepositoryCommon;
    private final ProductMapperDTO productMapperDTO;

    @Override
    public ProductDTO create(ProductRequest productRequest) {
        Product create = new Product(productCommandMapper.from(productRequest));
        return productMapperDTO.from(domainRepositoryCommon.save(create));
    }

    @Override
    public ProductDTO update(ProductRequest productRequest, Integer id) {
        Product findProduct = domainRepositoryCommon.findById(id);
        findProduct.update(productCommandMapper.from(productRequest));
        return productMapperDTO.from(domainRepositoryCommon.save(findProduct));
    }

    @Override
    public ProductDTO detail(Integer id) {
        return productMapperDTO.from(domainRepositoryCommon.findById(id));
    }

    @Override
    public void softDelete(Integer id) {
        Product findProduct = domainRepositoryCommon.findById(id);
        findProduct.softDelete();
        domainRepositoryCommon.softDelete(findProduct);
    }

    @Override
    public void inActive(Integer id) {
        Product findProduct = domainRepositoryCommon.findById(id);
        findProduct.inActive();
        domainRepositoryCommon.saveStatus(findProduct);
    }

    @Override
    public void active(Integer id) {
        Product findProduct = domainRepositoryCommon.findById(id);
        findProduct.active();
        domainRepositoryCommon.saveStatus(findProduct);
    }
}
