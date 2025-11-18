package com.tien.tai.domain.model;

import com.tien.tai.domain.command.OrderItemCmd;
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

public class OrderItemDomain {

    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Double price;
    private Integer orderId;
    private Integer measurementShirtID;
    private Integer measurementTrouserID;

    // Create từ Command
    public OrderItemDomain(OrderItemCmd cmd) {
        if (cmd == null) return;
        this.productId = cmd.getProductId();
        this.quantity = cmd.getQuantity();
        this.price = cmd.getPrice();
        this.orderId = cmd.getOrderId();
        this.measurementShirtID = cmd.getMeasurementShirtID();
        this.measurementTrouserID = cmd.getMeasurementTrouserID();
    }

    public void update(OrderItemCmd cmd) {
        if (cmd == null) return;
        if (cmd.getProductId() != null && cmd.getProductId() != 0) this.productId = cmd.getProductId();
        if (cmd.getQuantity() != null) this.quantity = cmd.getQuantity();
        if (cmd.getPrice() != null) this.price = cmd.getPrice();
        if (cmd.getOrderId() != null) this.orderId = cmd.getOrderId();
        if (cmd.getMeasurementShirtID() != null) this.measurementShirtID = cmd.getMeasurementShirtID();
        if (cmd.getMeasurementTrouserID() != null) this.measurementTrouserID = cmd.getMeasurementTrouserID();
    }
}

