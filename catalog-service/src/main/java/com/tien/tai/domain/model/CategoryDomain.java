package com.tien.tai.domain.model;


import com.tien.tai.domain.command.CategoryCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
@Getter
public class CategoryDomain {
    Integer id;
    String name;
    Boolean isDeleted;

    public CategoryDomain(CategoryCmd cmd) {
        this.name = cmd.getName();
        this.isDeleted = false;
    }

    public void update(CategoryCmd cmd) {
        this.name = cmd.getName();
        this.isDeleted = false;
    }

    public void softDelete() {
        this.isDeleted = true;
    }
}


