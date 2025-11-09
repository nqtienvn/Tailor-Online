package com.tien.tai.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tien.tai.infrastructor.persistence.model.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    Integer id;
    String fullName;
    String phoneNumber;
    String email;
    Gender gender;
    LocalDate dateOfBirth;
    String note;
    List<AddressDTO> addresses;
}