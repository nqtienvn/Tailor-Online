package com.tien.tai.application.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemCreateRequest {
     Integer productId;
     Integer quantity;
     Double price;
     Integer orderId;
     Integer measurementShirtID;
     Integer measurementTrouserID;
}
