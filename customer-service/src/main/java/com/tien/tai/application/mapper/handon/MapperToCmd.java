package com.tien.tai.application.mapper.handon;

import com.tien.tai.application.dto.request.AddressCreateRequest;
import com.tien.tai.application.dto.request.AddressUpdateRequest;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.domain.command.AddressCreateCmd;
import com.tien.tai.domain.command.AddressUpdateCmd;
import com.tien.tai.domain.command.CustomerCreateCmd;
import com.tien.tai.domain.command.CustomerUpdateCmd;
import com.tien.tai.infrastructor.persistence.model.AddressType;
import com.tien.tai.infrastructor.persistence.model.Gender;
import org.springframework.stereotype.Component;

@Component
public class MapperToCmd {
    public CustomerCreateCmd from(CustomerCreateRequest customerCreateRequest) {
        return CustomerCreateCmd.builder()
                .note(customerCreateRequest.getNote())
                .gender(Gender.fromString(customerCreateRequest.getGender()))
                .isTemporary(customerCreateRequest.getIsTemporary())
                .dateOfBirth(customerCreateRequest.getDateOfBirth())
                .email(customerCreateRequest.getEmail())
                .fullName(customerCreateRequest.getFullName())
                .phoneNumber(customerCreateRequest.getPhoneNumber())
                .build();
    }

    public CustomerUpdateCmd from(CustomerUpdateRequest customerCreateRequest) {
        return CustomerUpdateCmd.builder()
                .dateOfBirth(customerCreateRequest.getDateOfBirth())
                .fullName(customerCreateRequest.getFullName())
                .gender(Gender.fromString(customerCreateRequest.getGender()))
                .isTemporary(customerCreateRequest.getIsTemporary())
                .note(customerCreateRequest.getNote())
                .phoneNumber(customerCreateRequest.getPhoneNumber())
                .build();
    }

    public AddressCreateCmd from(AddressCreateRequest addressCreateRequest, Integer id) {
        return AddressCreateCmd.builder()
                .city(addressCreateRequest.getCity())
                .ward(addressCreateRequest.getWard())
                .addressType(AddressType.fromString(addressCreateRequest.getAddressType()))
                .customerId(id)
                .addressLine(addressCreateRequest.getAddressLine())
                .district(addressCreateRequest.getDistrict())
                .isDefault(addressCreateRequest.getIsDefault())
                .build();
    }

    public AddressUpdateCmd from(AddressUpdateRequest addressUpdateRequest) {
        return AddressUpdateCmd.builder()
                .city(addressUpdateRequest.getCity())
                .ward(addressUpdateRequest.getWard())
                .addressType(AddressType.fromString(addressUpdateRequest.getAddressType()))
                .addressLine(addressUpdateRequest.getAddressLine())
                .district(addressUpdateRequest.getDistrict())
                .build();
    }
}
