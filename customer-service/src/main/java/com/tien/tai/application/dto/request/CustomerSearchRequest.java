package com.tien.tai.application.dto.request;

import com.tien.common.dto.request.PagingRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerSearchRequest extends PagingRequest {
    String fullName;
    String phoneNumber;
    String email;
    String gender; //cái gender cần xử lý ở body luôn à
    LocalDate dateOfBirth;
    Boolean isTemporary;
}
