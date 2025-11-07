package com.tien.tai.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryResponse {
    Integer id;
    String name;
    Boolean isDeleted;
    private List<ProductResponse> products;
}
