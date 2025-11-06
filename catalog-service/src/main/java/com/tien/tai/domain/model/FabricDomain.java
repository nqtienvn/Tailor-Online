package com.tien.tai.domain.model;

import com.tien.tai.domain.command.FabricCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE) //chi goi dc setter ben trong class, chi de dam bao tinh encapsulation
@Getter
public class FabricDomain {
    Integer id;
    String name;
    String description;
    String color;
    Double pricePerMeter;
    String imageUrl;
    Double stockQuantity;
    Boolean status = true;
    Boolean isDeleted = false;

    public FabricDomain(FabricCmd cmd) {
        this.name = cmd.getName();
        this.color = cmd.getColor();
        this.pricePerMeter = cmd.getPricePerMeter();
        this.imageUrl = cmd.getImageUrl();
        this.description = cmd.getDescription();
        this.stockQuantity = cmd.getStockQuantity();
        this.isDeleted = false;
        this.status = true;
    }

    public void update(FabricCmd cmd) {
        if (cmd.getName() != null) this.name = cmd.getName();
        if (cmd.getColor() != null) this.color = cmd.getColor();
        if (cmd.getPricePerMeter() != null) this.pricePerMeter = cmd.getPricePerMeter();
        if (cmd.getDescription() != null) this.description = cmd.getDescription();
        if (cmd.getStockQuantity() != null) this.stockQuantity = cmd.getStockQuantity();
        if (cmd.getImageUrl() != null) this.imageUrl = cmd.getImageUrl();
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
