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
public class MeasurementSearchRequest extends PagingRequest {
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
