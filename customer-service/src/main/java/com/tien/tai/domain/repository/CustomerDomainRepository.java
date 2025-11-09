package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.domain.model.Customer;

import java.util.List;

public interface CustomerDomainRepository extends DomainRepositoryCommon<Customer, Integer> {
    void enrichDTO(List<CustomerDTO> customerDTOS);
}
