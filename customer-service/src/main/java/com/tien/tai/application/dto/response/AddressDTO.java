package com.tien.tai.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tien.tai.infrastructor.persistence.model.AddressType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    Integer id;
    Integer customerId;
    String addressLine;
    String city;
    String district;
    String ward;
    AddressType addressType;
    Boolean isDefault;
}
