package com.tien.tai.domain.model;

import com.tien.common.constant.OrderStatus;
import com.tien.tai.domain.command.OrderCmd;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    String customerPhone;
    String customerAddress;
    Double totalAmount;
    Double depositAmount;//tiền cọc
    OrderStatus status;

    public OrderDomain(OrderCmd cmd) {
        if (cmd == null) return;
        this.customerName = cmd.getCustomerName();
        this.customerPhone = cmd.getCustomerPhone();
        this.customerAddress = cmd.getCustomerAddress();
        this.totalAmount = cmd.getTotalAmount();
        this.depositAmount = cmd.getDepositAmount();
        this.status = OrderStatus.PENDING;
    }

    public void update(OrderCmd cmd) {
        if (cmd == null) return;
        if (cmd.getCustomerName() != null) this.customerName = cmd.getCustomerName();
        if (cmd.getCustomerPhone() != null) this.customerPhone = cmd.getCustomerPhone();
        if (cmd.getCustomerAddress() != null) this.customerAddress = cmd.getCustomerAddress();
        if (cmd.getTotalAmount() != null) this.totalAmount = cmd.getTotalAmount();
        if (cmd.getDepositAmount() != null) this.depositAmount = cmd.getDepositAmount();
        if (cmd.getStatus() != null) this.status = cmd.getStatus();
    }
}
