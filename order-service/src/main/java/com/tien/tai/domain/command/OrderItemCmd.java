package com.tien.tai.domain.command;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemCmd {
    Integer productId;
    Integer quantity;
    Double price;
    Integer orderId;
    Integer measurementShirtID;
    Integer measurementTrouserID;
}
