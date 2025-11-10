package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.domain.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapperDTO {
    AddressDTO toDTO(Address address);
    List<AddressDTO> toDTO(List<Address> addresses);
}
