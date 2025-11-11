package com.tien.tai.domain.model;


import com.tien.tai.domain.command.CategoryCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
@Getter
public class Category {
    Integer id;
    String name;
    Boolean isDeleted;
    List<Product> products;


    public Category(CategoryCmd cmd) {
        this.name = cmd.getName();
        this.isDeleted = false;
    }

    public void update(CategoryCmd cmd) {
        if (cmd.getName() != null) this.name = cmd.getName();
        this.isDeleted = false;
    }

    public void softDelete() {
        this.isDeleted = true;
    }

    public void enrichProduct(List<Product> products) {
        this.products = products;
    }
}


