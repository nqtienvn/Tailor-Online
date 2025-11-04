package com.tien.tai.domain.service;

import com.tien.tai.domain.command.CategoryCreateCmd;
import com.tien.tai.domain.model.CategoryDomain;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory {
    public CategoryDomain create(CategoryCreateCmd cmd) {
        return CategoryDomain.builder()
                .name(cmd.getName())
                .build();
    }
}


