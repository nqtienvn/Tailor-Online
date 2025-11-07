package com.tien.tai.application.dto.request;

import com.tien.common.dto.request.PagingRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductSearchRequest extends PagingRequest {
    Integer categoryId;
    Integer fabricId;
    String name;
    Double basePrice;
}
