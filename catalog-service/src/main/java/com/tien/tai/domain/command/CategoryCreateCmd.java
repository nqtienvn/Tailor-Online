package com.tien.tai.domain.command;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateCmd {
    String name;
}
