package com.tien.tai.application.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    Integer categoryId;
    Integer fabricId;
    String name;
    String description;
    Double basePrice;
}
