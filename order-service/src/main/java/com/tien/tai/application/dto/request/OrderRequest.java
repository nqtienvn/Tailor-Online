package com.tien.tai.application.dto.request;
import com.tien.common.constant.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {

    String customerName;
    String phone;
    String address;
    OrderStatus status;
    LocalDateTime orderDate;
    LocalDateTime completedDate;
}