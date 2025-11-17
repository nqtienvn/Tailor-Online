package com.tien.tai.domain.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tien.common.constant.OrderStatus;
import com.tien.common.query.PagingQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class OrderSeachQuery extends PagingQuery {
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
