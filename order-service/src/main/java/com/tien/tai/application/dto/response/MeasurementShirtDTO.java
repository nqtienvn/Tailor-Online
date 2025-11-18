package com.tien.tai.application.dto.response;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeasurementShirtDTO {
    private Integer id;
    private Double chest;
    private Double shoulder;
    private Double sleeveLength;
    private Double armhole;
    private Double bicep;
    private Double neck;
    private Double shirtLength;
    private Boolean status = true;
    private Boolean isDeleted = false;
}
