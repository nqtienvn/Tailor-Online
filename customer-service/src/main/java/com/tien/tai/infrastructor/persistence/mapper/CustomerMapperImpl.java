package com.tien.tai.infrastructor.persistence.mapper;

import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Customer;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CustomerMapperImpl implements ToEntityDomain<CustomerEntity, Customer> {
    @Override
    public CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .status(customer.getStatus())
                .isTemporary(customer.getIsTemporary())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .note(customer.getNote())
                .dateOfBirth(customer.getDateOfBirth())
                .gender(customer.getGender())
                .phoneNumber(String.valueOf(customer.getPhoneNumber()))
                .build();
    }

    @Override
    public List<Customer> toDomain(List<CustomerEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer toDomain(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .status(customerEntity.getStatus())
                .isTemporary(customerEntity.getIsTemporary())
                .email(customerEntity.getEmail())
                .fullName(customerEntity.getFullName())
                .note(customerEntity.getNote())
                .dateOfBirth(customerEntity.getDateOfBirth())
                .gender(customerEntity.getGender())
                .phoneNumber(String.valueOf(customerEntity.getPhoneNumber()))
                .build();
    }
}
