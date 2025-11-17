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
public class OrderItemSearchRequest extends PagingRequest {
    private Integer productId;

    // tìm theo khoảng số lượng
    private Integer quantityFrom;
    private Integer quantityTo;

    // tìm theo khoảng đơn giá (unit_price)
    private Double priceFrom;
    private Double priceTo;

    // tổng tiền mỗi item (subtotal)
    private Double subtotalFrom;
    private Double subtotalTo;

    // lọc theo loại vải (LIKE)
    private String fabricType;

    // trạng thái active/inactive
    private Boolean status;

    // xóa mềm
    @JsonProperty("isDeleted")
    private Boolean isDeleted;

    // lọc theo order cha
    private Integer orderId;

}
