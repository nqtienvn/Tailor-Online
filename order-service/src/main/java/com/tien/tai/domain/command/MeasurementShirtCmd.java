package com.tien.tai.domain.command;

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
public class MeasurementShirtCmd {
    Double chest;
    Double shoulder;
    Double sleeveLength;
    Double armhole;
    Double bicep;
    Double neck;
    Double shirtLength;
}
