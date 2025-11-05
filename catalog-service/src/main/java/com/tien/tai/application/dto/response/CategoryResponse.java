package com.tien.tai.application.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryResponse {
    Integer id;
    String name;
    Boolean isDeleted;
}
