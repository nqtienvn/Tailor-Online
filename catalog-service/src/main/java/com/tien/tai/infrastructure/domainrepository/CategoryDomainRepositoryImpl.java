package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.application.dto.mapper.entitytoresponse.MapperEntityToResponse;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.application.dto.response.ProductDTO;
import com.tien.tai.domain.model.Category;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import com.tien.tai.infrastructure.persistence.model.CategoryEntity;
import com.tien.tai.infrastructure.persistence.model.ProductEntity;
import com.tien.tai.infrastructure.persistence.repository.CategoryRepository;
import com.tien.tai.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryDomainRepositoryImpl implements CategoryDomainRepository {
    private final CategoryRepository categoryRepository;
    private final ToEntityDomain<CategoryEntity, Category> toEntityDomain;
    private final ProductRepository productRepository;
    private final MapperEntityToResponse mapperEntityToResponse;

    @Override
    public Category save(Category category) {
        CategoryEntity savedEntity = categoryRepository.save(toEntityDomain.toEntity(category));
        return toEntityDomain.toDomain(savedEntity);
    }

    @Override
    public Category findById(Integer id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException(new AppException(NotFoundError.NOT_FOUND)));
        return toEntityDomain.toDomain(categoryEntity);
    }

    @Override
    public void softDelete(Category category) {
        categoryRepository.save(toEntityDomain.toEntity(category));
    }

    @Override
    public void saveStatus(Category domain) {
    }

    @Override
    public void enrichDTO(List<CategoryDTO> categoryDtos) {
        if (categoryDtos == null || categoryDtos.isEmpty()) return;

        List<Integer> categoryIds = categoryDtos.stream()
                .map(CategoryDTO::getId) //get het id ra tu list DTO
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<ProductEntity> products = productRepository.findByCategoryIdIn(categoryIds); //lay toan bo product lien quan den categoryID
        List<ProductDTO> productDtoList = mapperEntityToResponse.toProductDTOs(products);

        Map<Integer, List<ProductDTO>> productsByCategory = productDtoList.stream() //map gia tri theo map categoryId va gia tri product
                .collect(Collectors.groupingBy(ProductDTO::getCategoryId));

        categoryDtos.forEach(categoryDTO -> categoryDTO.setProducts(productsByCategory
                .getOrDefault(categoryDTO.getId(), List.of())));
    }
}
