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
        this.phone = cmd.getPhone();
        this.address = cmd.getAddress();
        this.status = cmd.getStatus();
        this.orderDate = cmd.getOrderDate();
        this.completedDate = cmd.getCompletedDate();
    }

    public void update(OrderCmd cmd) {
        if (cmd == null) return;

        if (cmd.getCustomerName() != null) this.customerName = cmd.getCustomerName();
        if (cmd.getPhone() != null) this.phone = cmd.getPhone();
        if (cmd.getAddress() != null) this.address = cmd.getAddress();
        if (cmd.getStatus() != null) this.status = cmd.getStatus();
        if (cmd.getOrderDate() != null) this.orderDate = cmd.getOrderDate();
        if (cmd.getCompletedDate() != null) this.completedDate = cmd.getCompletedDate();
    }
    public void softDelete(){
        this.isDeleted = true;
    }
}
