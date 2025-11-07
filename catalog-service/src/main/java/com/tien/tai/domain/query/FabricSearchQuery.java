package com.tien.tai.domain.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tien.common.query.PagingQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class FabricSearchQuery extends PagingQuery {
    String name;
    String color;
    Boolean status;
    @JsonProperty("isDeleted")
    Boolean isDeleted;
}
