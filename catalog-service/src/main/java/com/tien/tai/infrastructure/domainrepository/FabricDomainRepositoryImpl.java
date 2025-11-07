package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.application.dto.mapper.entitytoresponse.MapperEntityToResponse;
import com.tien.tai.application.dto.response.FabricResponse;
import com.tien.tai.application.dto.response.ProductResponse;
import com.tien.tai.domain.model.Fabric;
import com.tien.tai.domain.repository.FabricDomainRepository;
import com.tien.tai.infrastructure.persistence.model.FabricEntity;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import com.tien.tai.infrastructure.persistence.repository.FabricRepository;
import com.tien.tai.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FabricDomainRepositoryImpl implements FabricDomainRepository {
    private final FabricRepository fabricRepository;
    private final ToEntityDomain<FabricEntity, Fabric> toEntityDomain;
    private final MapperEntityToResponse mapperEntityToResponse;
    private final ProductRepository productRepository;

    @Override
    public Fabric save(Fabric fabric) {
        FabricEntity savedFabricEntity = fabricRepository.save(toEntityDomain.toEntity(fabric));
        return toEntityDomain.toDomain(savedFabricEntity);
    }

    @Override
    public Fabric findById(Integer id) {
        return toEntityDomain.toDomain(fabricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(new AppException(NotFoundError.NOT_FOUND))));
    }

    @Override
    public void softDelete(Fabric fabric) {
        fabricRepository.save(toEntityDomain.toEntity(fabric));
    }

    @Override
    public void saveStatus(Fabric fabric) {
        fabricRepository.save(toEntityDomain.toEntity(fabric));
    }

    @Override
    public void enrichDTO(List<FabricResponse> fabricDTOS) {
        if (fabricDTOS == null || fabricDTOS.isEmpty()) return;

        List<Integer> categoryIds = fabricDTOS.stream()
                .map(FabricResponse::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<ProductEntity> products = productRepository.findByFabricIdIn(categoryIds);
        List<ProductResponse> productDtos = mapperEntityToResponse.toProductDTOs(products);

        Map<Integer, List<ProductResponse>> productsByCategory = productDtos.stream()
                .collect(Collectors.groupingBy(ProductResponse::getCategoryId));

        for (FabricResponse fabric : fabricDTOS) {
            List<ProductResponse> relatedProducts = productsByCategory.getOrDefault(fabric.getId(), List.of());
            fabric.setProducts(relatedProducts);
        }
    }
}
