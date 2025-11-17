package com.tien.tai.domain.model;

import com.tien.tai.domain.command.OrderItemCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderItemDomain {
    Integer id;

    Integer productId;
    Integer quantity;
    Double price;
    String fabricType;

    Integer orderID;

    Boolean status = true;
    Boolean isDeleted = false;

    public OrderItemDomain(OrderItemCmd cmd){
        this.productId = cmd.getProductId();
        this.quantity = cmd.getQuantity();
        this.price = cmd.getPrice();
        this.fabricType = cmd.getFabricType();
        this.orderID = cmd.getOrderID();
        this.status = true;
        this.isDeleted = false;
    }
    public void update(OrderItemCmd cmd) {
        if (cmd == null) return;

        if (cmd.getProductId() != 0) this.productId = cmd.getProductId();
        if (cmd.getQuantity() != null) this.quantity = cmd.getQuantity();
        if (cmd.getPrice() != null) this.price = cmd.getPrice();
        if (cmd.getFabricType() != null) this.fabricType = cmd.getFabricType();
        if (cmd.getOrderID() > 0) this.orderID = cmd.getOrderID();
    }
    public void softDelete() {
        this.isDeleted = true;
        this.status = false;
    }

    public void inActive() {
        this.status = false;
    }

    public void active() {
        this.status = true;
    }

}
