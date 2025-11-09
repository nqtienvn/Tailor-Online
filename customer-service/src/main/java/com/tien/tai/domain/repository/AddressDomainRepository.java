package com.tien.tai.domain.repository;

import com.tien.common.domain.repository.DomainRepositoryCommon;
import com.tien.tai.domain.model.Address;

import java.util.List;

public interface AddressDomainRepository extends DomainRepositoryCommon<Address, Integer> {
    List<Address> findAddressByCustomerId(Integer id);
    Boolean delete(Integer id);
}
