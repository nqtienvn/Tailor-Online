package com.tien.tai.domain.command;

import com.tien.common.constant.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderCmd {
    String customerName;
    String phone;
    String address;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    LocalDateTime orderDate;
    LocalDateTime completedDate;


}
