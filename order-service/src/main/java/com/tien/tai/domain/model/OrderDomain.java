package com.tien.tai.domain.model;

import com.tien.common.constant.OrderStatus;
import com.tien.tai.domain.command.OrderCmd;
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

public class OrderDomain {
    Integer id;

    String customerName;
    String phone;
    String address;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    LocalDateTime orderDate;
    LocalDateTime completedDate;

    Boolean isDeleted = false;

    public OrderDomain(OrderCmd cmd) {
        this.customerName = cmd.getCustomerName();
    }

    public void update(OrderCmd cmd) {
        if (cmd == null) return;

        if (cmd.getCustomerName() != null) this.customerName = cmd.getCustomerName();
    }
    public void softDelete(){
        this.isDeleted = true;
    }
}
