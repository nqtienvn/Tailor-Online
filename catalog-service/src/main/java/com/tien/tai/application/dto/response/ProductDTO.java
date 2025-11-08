package com.tien.tai.application.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    Integer id;
    Integer categoryId;
    Integer fabricId;
    String name;
    String description;
    Double basePrice;
    Boolean status;
    Boolean isDeleted;
}
