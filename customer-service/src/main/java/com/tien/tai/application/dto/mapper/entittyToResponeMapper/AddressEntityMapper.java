package com.tien.tai.application.dto.mapper.entittyToResponeMapper;

import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.infrastructor.persistence.model.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressEntityMapper {
    public List<AddressDTO> toAddressDTOs(List<AddressEntity> entities) {
        return entities.stream()
                .map(e -> AddressDTO.builder()
                        .id(e.getId())
                        .addressLine(e.getAddressLine())
                        .customerId(e.getCustomerId())
                        .isDefault(e.getIsDefault())
                        .district(e.getDistrict())
                        .ward(e.getWard())
                        .city(e.getCity())
                        .addressType(e.getAddressType()).build())
                .collect(Collectors.toList());
    }
}
