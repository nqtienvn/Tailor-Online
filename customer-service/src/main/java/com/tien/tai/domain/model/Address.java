package com.tien.tai.domain.model;

import com.tien.tai.domain.command.AddressCreateCmd;
import com.tien.tai.domain.command.AddressUpdateCmd;
import com.tien.tai.infrastructor.persistence.model.AddressType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE) //chi goi dc setter ben trong class, chi de dam bao tinh encapsulation
@Getter
public class Address {
    Integer id;
    Integer customerId;
    String addressLine;
    String city;
    String district;
    String ward;
    AddressType addressType;
    Boolean isDefault;

    public Address(AddressCreateCmd addressCreateCmd) {
        this.addressLine = addressCreateCmd.getAddressLine();
        this.city = addressCreateCmd.getCity();
        this.addressType = addressCreateCmd.getAddressType();
        this.customerId = addressCreateCmd.getCustomerId();
        this.district = addressCreateCmd.getDistrict();
        this.isDefault = addressCreateCmd.getIsDefault();
        this.ward = addressCreateCmd.getWard();
    }

    public void update(AddressUpdateCmd cmd) {
        if (cmd.getAddressLine() != null) this.addressLine = cmd.getAddressLine();
        if (cmd.getCity() != null) this.city = cmd.getCity();
        if (cmd.getAddressType() != null) this.addressType = cmd.getAddressType();
        if (cmd.getDistrict() != null) this.district = cmd.getDistrict();
        if (cmd.getWard() != null) this.ward = cmd.getWard();
    }
}
