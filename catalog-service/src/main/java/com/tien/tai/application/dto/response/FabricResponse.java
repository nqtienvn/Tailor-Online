package com.tien.tai.application.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FabricResponse {
    Integer id;
    String name;
    String description;
    String color;
    Double pricePerMeter;
    String imageUrl;
    Double stockQuantity;
    Boolean status;
    Boolean isDeleted;
    private List<ProductResponse> products;
}
