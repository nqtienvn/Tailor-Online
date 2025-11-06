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
public class ProductDomain {
    Integer id;
    Integer categoryId;
    Integer fabricId;
    String name;
    String description;
    Double basePrice;
    Boolean status = true;
    Boolean isDeleted = false;

    public ProductDomain(ProductCmd cmd) {
        this.categoryId = cmd.getCategoryId();
        this.fabricId = cmd.getFabricId();
        this.status = true;
        this.isDeleted = false;
        this.name = cmd.getName();
        this.description = cmd.getDescription();
        this.basePrice = cmd.getBasePrice();
    }

}
