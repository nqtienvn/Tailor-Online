package com.tien.tai.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tien.common.dto.request.PagingRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FabricSearchRequest extends PagingRequest {
    String name;
    String color;
    Boolean status;
    @JsonProperty("isDeleted")
    Boolean isDeleted;
}
