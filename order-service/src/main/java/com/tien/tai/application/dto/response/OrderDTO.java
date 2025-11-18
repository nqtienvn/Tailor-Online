package com.tien.tai.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    Integer id;
    String customerName;
    String customerPhone;
    String customerAddress;
    Double totalAmount;
    Double depositAmount;
    OrderStatus status;
}
