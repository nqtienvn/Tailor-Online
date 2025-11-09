package com.tien.tai.application.mapper.handon;

import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.domain.command.CustomerCreateCmd;
import com.tien.tai.domain.command.CustomerUpdateCmd;
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
}
