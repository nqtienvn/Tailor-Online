package com.tien.tai.infrastructor.persistence.repository;

import com.tien.tai.infrastructor.persistence.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findAddressEntityByCustomerId(Integer customerId);
}
