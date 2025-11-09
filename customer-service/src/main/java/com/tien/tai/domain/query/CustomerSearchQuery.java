package com.tien.tai.domain.query;

import com.tien.common.query.PagingQuery;
import com.tien.tai.infrastructor.persistence.model.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class CustomerSearchQuery extends PagingQuery {
    String fullName;
    String phoneNumber;
    String email;
    Gender gender; //cái gender cần xử lý ở body luôn à
    LocalDate dateOfBirth;
    Boolean isTemporary;
}
