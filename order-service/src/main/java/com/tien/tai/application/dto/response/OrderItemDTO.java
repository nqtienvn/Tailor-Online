package com.tien.tai.application.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderItemDTO {
    Integer id;
    Integer productId;
    Integer quantity;
    Double price;
    String fabricType;
    Boolean status;
    Boolean isDeleted;
    Integer orderID;
}
