package com.tien.tai.domain.model;

import com.tien.tai.domain.command.ProductCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE) //chi goi dc setter ben trong class, chi de dam bao tinh encapsulation
@Getter
public class Product {
    Integer id;
    Integer categoryId;
    Integer fabricId;
    String name;
    String description;
    Double basePrice;
    Boolean status = true;
    Boolean isDeleted = false;

    public Product(ProductCmd cmd) {
        this.categoryId = cmd.getCategoryId();
        this.fabricId = cmd.getFabricId();
        this.status = true;
        this.isDeleted = false;
        this.name = cmd.getName();
        this.description = cmd.getDescription();
        this.basePrice = cmd.getBasePrice();
    }

    public void update(ProductCmd cmd) {
        if (cmd.getName() != null) this.name = cmd.getName();
        if (cmd.getBasePrice() != null) this.basePrice = cmd.getBasePrice();
        if (cmd.getDescription() != null) this.description = cmd.getDescription();
        if (cmd.getCategoryId() != null) this.categoryId = cmd.getCategoryId();
        if (cmd.getFabricId() != null) this.fabricId = cmd.getFabricId();
        this.isDeleted = false;
        this.status = true;
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
