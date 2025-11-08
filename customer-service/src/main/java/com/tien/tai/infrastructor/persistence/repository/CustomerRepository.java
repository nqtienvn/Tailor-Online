package com.tien.tai.infrastructor.persistence.repository;

import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
