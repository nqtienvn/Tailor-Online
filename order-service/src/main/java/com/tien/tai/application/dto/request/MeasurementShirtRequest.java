package com.tien.tai.application.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementShirtRequest {
     Double chest;
     Double shoulder;
     Double sleeveLength;
     Double armhole;
     Double bicep;
     Double neck;
     Double shirtLength;
}