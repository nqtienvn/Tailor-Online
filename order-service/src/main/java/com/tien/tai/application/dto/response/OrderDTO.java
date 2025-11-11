package com.tien.tai.application.dto.response;
import com.tien.common.constant.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderDTO {
    Integer id;
    String customerName;
    String phone;
    String address;
    OrderStatus status;
    LocalDateTime orderDate;
    LocalDateTime completedDate;
    Boolean isDeleted;

    List<OrderItemDTO> orderItems;
    MeasurementDTO measurement;
}
