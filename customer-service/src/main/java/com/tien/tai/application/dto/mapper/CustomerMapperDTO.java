package com.tien.tai.application.dto.mapper;

import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.domain.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapperDTO {
    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTO(List<Customer> customers);
}
