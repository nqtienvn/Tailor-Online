package com.tien.tai.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tien.common.constant.OrderStatus;
import com.tien.common.dto.request.PagingRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderSearchRequest extends PagingRequest {
    String customerName;
    String phone;
    String address;

    @JsonProperty("isDeleted")
    Boolean isDeleted;

    OrderStatus status;

    // lọc theo ngày đặt hàng
    LocalDateTime orderDateFrom;
    LocalDateTime orderDateTo;

    // lọc theo ngày hoàn thành
    LocalDateTime completedDateFrom;
    LocalDateTime completedDateTo;
}
