package com.tien.tai.domain.command;

import com.tien.tai.infrastructor.persistence.model.AddressType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressCreateCmd {
    Integer customerId;
    String addressLine;
    String city;
    String district;
    String ward;
    AddressType addressType;
    Boolean isDefault;
}
//can phai xu ly tu request ve dto