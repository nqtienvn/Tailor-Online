package com.tien.tai.application.dto.request;

import com.tien.tai.infrastructor.persistence.model.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerCreateRequest {
    String fullName;
    String phoneNumber;
    String email;
    String gender; //cái gender cần xử lý ở body luôn à
    LocalDate dateOfBirth;
    String note;
    Boolean isTemporary;
}
