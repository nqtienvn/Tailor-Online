package com.tien.tai.application.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementDTO {
    Integer id;
    Double chest;
    Double waist;
    Double hips;
    Double shoulder;
    Double sleeveLength;
    Double trouserLength;
    Boolean status;
    Boolean isDeleted;
}
