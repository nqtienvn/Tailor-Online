package com.tien.tai.domain.command;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCmd {
    Integer categoryId;
    Integer fabricId;
    String name;
    String description;
    Double basePrice;
}
