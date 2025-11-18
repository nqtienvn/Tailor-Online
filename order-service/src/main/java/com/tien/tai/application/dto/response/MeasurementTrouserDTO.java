package com.tien.tai.application.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementTrouserDTO {
    private Integer id;
    private Double trouserLength;
    private Double waist;
    private Double hips;
    private Double knee;
    private Double legWidth;
    private Boolean status = true;
    private Boolean isDeleted = false;
}
