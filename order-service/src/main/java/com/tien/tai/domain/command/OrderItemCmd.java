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
    String productName;
    Integer quantity;
    Double price;
    String fabricType;


    int orderID;
}
