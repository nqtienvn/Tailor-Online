package com.tien.tai.infrastructor.persistence.mapper;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Address;
import com.tien.tai.infrastructor.persistence.model.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class AddressMapperImpl implements ToEntityDomain<AddressEntity, Address> {
    @Override
    public AddressEntity toEntity(Address domain) {
        return AddressEntity.builder()
                .id(domain.getId())
                .addressLine(domain.getAddressLine())
                .addressType(domain.getAddressType())
                .city(domain.getCity())
                .ward(domain.getWard())
                .district(domain.getDistrict())
                .isDefault(domain.getIsDefault())
                .customerId(domain.getCustomerId())
                .build();
    }

    @Override
    public List<Address> toDomain(List<AddressEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Address toDomain(AddressEntity entity) {
        return Address.builder()
                .id(entity.getId())
                .addressLine(entity.getAddressLine())
                .addressType(entity.getAddressType())
                .city(entity.getCity())
                .ward(entity.getWard())
                .district(entity.getDistrict())
                .isDefault(entity.getIsDefault())
                .customerId(entity.getCustomerId())
                .build();
    }
}
