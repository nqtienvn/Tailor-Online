package com.tien.tai.unit.domain;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.tai.application.dto.mapper.CategoryMapperDTO;
import com.tien.tai.application.dto.response.CategoryDTO;
import com.tien.tai.application.mapper.CategoryCommandMapper;
import com.tien.tai.application.service.command.impl.impl.CategoryCommandServiceCatalogImpl;
import com.tien.tai.domain.model.Category;
import com.tien.tai.domain.repository.CategoryDomainRepository;
import com.tien.tai.domain.repository.ProductDomainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@SpringBootTest
class CategoryCommandServiceTest {
    @Mock
    private CategoryDomainRepository categoryDomainRepository;
    @Mock
    private CategoryCommandMapper categoryCommandMapper;
    @Mock
    private ProductDomainRepository productDomainRepository;
    @Mock
    private CategoryMapperDTO categoryMapperDTO;
    private Category mockCategory;
    @InjectMocks
    private CategoryCommandServiceCatalogImpl categoryCommandServiceCatalogImpl;

    @BeforeEach
    void setUp() {
        mockCategory = new Category(1, "cate-test", false, null);
    }

    @Test
    void testDetail_ShouldReturnCategoryDetail() {
        when(categoryDomainRepository.findById(mockCategory.getId())).thenReturn(mockCategory);
        when(categoryMapperDTO.from(mockCategory)).thenReturn(CategoryDTO.builder() //moc luon
                .id(mockCategory.getId())
                .isDeleted(false)
                .name(mockCategory.getName())
                .products(null)
                .build());
        CategoryDTO dto = categoryCommandServiceCatalogImpl.detail(mockCategory.getId());
        assertEquals(1, dto.getId());
        assertEquals("cate-test", dto.getName());
        verify(categoryDomainRepository, times(1)).findById(mockCategory.getId());
        verify(categoryMapperDTO, times(1)).from(mockCategory);
    }

    @Test
    void testDetail_ShouldThrowNotFoundException_WhenCategoryNotExist() {
        int id = 999;
        when(categoryDomainRepository.findById(id))
                .thenThrow(new AppException(NotFoundError.NOT_FOUND));
        AppException thrown = assertThrows(
                AppException.class,
                () -> categoryCommandServiceCatalogImpl.detail(id)
        );
        assertEquals(NotFoundError.NOT_FOUND, thrown.getErrorCode());
        verify(categoryDomainRepository, times(1)).findById(id);
        verifyNoInteractions(categoryMapperDTO);
    }
}
