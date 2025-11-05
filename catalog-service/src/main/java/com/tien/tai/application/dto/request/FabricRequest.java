package com.tien.tai.application.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FabricRequest {
    String name;
    String description;
    String color;
    Double pricePerMeter;
    String imageUrl;
    Double stockQuantity;
}
