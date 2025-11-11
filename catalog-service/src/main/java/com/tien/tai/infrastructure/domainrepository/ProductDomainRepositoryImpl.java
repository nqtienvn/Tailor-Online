package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Product;
import com.tien.tai.domain.repository.ProductDomainRepository;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import com.tien.tai.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDomainRepositoryImpl implements ProductDomainRepository {
    private final ToEntityDomain<ProductEntity, Product> toEntityDomain;
    private final ProductRepository productRepository;

    @Override
    public Product save(Product domain) {
        return toEntityDomain.toDomain(productRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public Product findById(Integer id) {
        return toEntityDomain.toDomain(productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }


    @Override
    public void softDelete(Product domain) {
        productRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void saveStatus(Product domain) {
        productRepository.save(toEntityDomain.toEntity(domain));

    }
}
