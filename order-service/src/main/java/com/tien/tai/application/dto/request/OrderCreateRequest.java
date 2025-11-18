package com.tien.tai.application.dto.request;

import com.tien.common.constant.OrderStatus;
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
public class OrderCreateRequest {
    String customerName;
    String customerPhone;
    String customerAddress;
    Double totalAmount;
    Double depositAmount;//tiền cọc
    OrderStatus status;
}