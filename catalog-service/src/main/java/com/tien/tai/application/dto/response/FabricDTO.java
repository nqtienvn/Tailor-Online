package com.tien.tai.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FabricDTO {
    Integer id;
    String name;
    String description;
    String color;
    Double pricePerMeter;
    String imageUrl;
    Double stockQuantity;
    Boolean status;
    Boolean isDeleted;
    private List<ProductDTO> products;
}
