package com.tien.tai.domain.command;

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
public class CustomerCreateCmd {
    String fullName;
    String phoneNumber;
    String email;
    Gender gender;
    LocalDate dateOfBirth;
    String note;
    Boolean isTemporary;
}
