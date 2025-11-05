package com.tien.tai.domain.command;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FabricCmd {
    String name;
    String description;
    String color;
    Double pricePerMeter;
    String imageUrl;
    Double stockQuantity;
}
