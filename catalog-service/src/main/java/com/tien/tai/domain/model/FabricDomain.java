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
        this.name = cmd.getName();
        this.isDeleted = false;
        this.status = true;
        this.color = cmd.getColor();
        this.pricePerMeter = cmd.getPricePerMeter();
        this.description = cmd.getDescription();
        this.stockQuantity = cmd.getStockQuantity();
        this.imageUrl = cmd.getImageUrl();
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
