package com.tien.tai.domain.command;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementCmd {

    Double chest;
    Double waist;
    Double hips;
    Double shoulder;
    Double sleeveLength;
    Double trouserLength;

    int orderID;


}
