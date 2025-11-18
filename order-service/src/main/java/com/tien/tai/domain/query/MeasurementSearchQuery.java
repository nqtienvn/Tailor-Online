package com.tien.tai.domain.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tien.common.query.PagingQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class MeasurementSearchQuery extends PagingQuery   {
    // lọc theo id (nếu cần tìm 1 item nhanh)
    Integer id;

    // Lọc theo khoảng số đo
    Double chestFrom;
    Double chestTo;

    Double waistFrom;
    Double waistTo;

    Double hipsFrom;
    Double hipsTo;

    Double shoulderFrom;
    Double shoulderTo;

    Double sleeveLengthFrom;
    Double sleeveLengthTo;

    Double trouserLengthFrom;
    Double trouserLengthTo;

    // Lọc theo status (active/inactive)
    Boolean status;

    // Cờ xóa mềm
    @JsonProperty("isDeleted")
    Boolean isDeleted;

    // Lọc theo Order
    Integer orderId;
}
