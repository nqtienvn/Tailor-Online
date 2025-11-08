package com.tien.tai.application.service.query.impl;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.common.service.ServiceQueryCommon;
import com.tien.tai.application.dto.mapper.ProductMapperDTO;
import com.tien.tai.application.dto.request.ProductSearchRequest;
import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.application.mapper.AutoMapperQuery;
import com.tien.tai.domain.model.Product;
import com.tien.tai.domain.query.ProductSearchQuery;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import com.tien.tai.infrastructure.persistence.repository.ProductRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ServiceQueryCommon<PageDTO<ProductDTO>, ProductSearchRequest> {
    private final AutoMapperQuery autoMapperQuery;
    private final ProductRepositoryCustom productRepositoryCustom;
    private final ProductMapperDTO productMapperDTO;
    private final ToEntityDomain<ProductEntity, Product> toEntityDomain;

    @Override
    public PageDTO<ProductDTO> search(ProductSearchRequest request) {
        ProductSearchQuery searchQuery = this.autoMapperQuery.from(request);
        Long total = this.productRepositoryCustom.count(searchQuery);
        if (Objects.equals(total, 0L)) {
            return PageDTO.empty();
        }
        List<Product> products = this.toEntityDomain.toDomain(this.productRepositoryCustom.search(searchQuery));
        List<ProductDTO> productDtos = this.productMapperDTO.toDTO(products);
        return new PageDTO<>(productDtos, request.getPageIndex(), request.getPageSize(), total);
    }
}
