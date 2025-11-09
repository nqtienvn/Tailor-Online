package com.tien.tai.infrastructor.persistence.repository;

import com.tien.tai.domain.query.CustomerSearchQuery;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;

import java.util.List;

public interface CustomerRepositoryCustomer {
    Long count(CustomerSearchQuery params);

    List<CustomerEntity> search(CustomerSearchQuery params);
}
