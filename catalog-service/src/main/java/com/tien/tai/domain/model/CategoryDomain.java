package com.tien.tai.domain.model;


import com.tien.tai.domain.command.CategoryCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDomain {
    Integer id;
    String name;

    public static CategoryDomain create(CategoryCmd cmd) {
        return CategoryDomain.builder().name(cmd.getName()).build();
    }

    public CategoryDomain update(CategoryCmd cmd) {
        return null;
    }

    public void delete(Integer id) {

    }
}


