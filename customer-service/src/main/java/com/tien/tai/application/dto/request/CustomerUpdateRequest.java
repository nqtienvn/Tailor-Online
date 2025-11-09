package com.tien.tai.application.dto.request;

import com.tien.tai.infrastructor.persistence.model.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerUpdateRequest {
    String fullName;
    String phoneNumber;
    //    String email;
    String gender;
    LocalDate dateOfBirth;
    String note;
    Boolean isTemporary;
}
