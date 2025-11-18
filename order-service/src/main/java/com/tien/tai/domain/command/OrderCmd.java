package com.tien.tai.domain.command;

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
public class OrderCmd {
    String customerName;
    String customerPhone;
    String customerAddress;
    Double totalAmount;
    Double depositAmount;//tiền cọc
    OrderStatus status;
}
