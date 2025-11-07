package com.tien.tai.domain.query;

import com.tien.common.query.PagingQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ProductSearchQuery extends PagingQuery {
    Integer categoryId;
    Integer fabricId;
    String name;
    Double basePrice;
}