package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.ProductDomain;
import com.tien.tai.infrastructure.persistence.model.Product;
import com.tien.tai.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDomainRepositoryImpl implements DomainRepositoryCommon<ProductDomain, Integer> {
    private final ToEntityDomain<Product, ProductDomain> toEntityDomain;
    private final ProductRepository productRepository;

    @Override
    public ProductDomain save(ProductDomain domain) {
        return toEntityDomain.toDomain(productRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public ProductDomain findById(Integer id) {
        return toEntityDomain.toDomain(productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(ProductDomain domain) {
        productRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void saveStatus(ProductDomain domain) {
        productRepository.save(toEntityDomain.toEntity(domain));

    }
}
