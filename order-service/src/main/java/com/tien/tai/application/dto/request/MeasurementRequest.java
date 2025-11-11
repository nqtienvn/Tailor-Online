package com.tien.tai.application.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementRequest {

    Double chest;
    Double waist;
    Double hips;
    Double shoulder;
    Double sleeveLength;
    Double trouserLength;
    Boolean status;
    Integer orderID;
}