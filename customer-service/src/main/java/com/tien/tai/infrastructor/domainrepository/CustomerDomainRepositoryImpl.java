package com.tien.tai.infrastructor.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Customer;
import com.tien.tai.domain.repository.CustomerDomainRepository;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import com.tien.tai.infrastructor.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerDomainRepositoryImpl implements CustomerDomainRepository {
    private final ToEntityDomain<CustomerEntity, Customer> toEntityDomain;
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return toEntityDomain.toDomain(customerRepository.save(toEntityDomain.toEntity(customer)));
    }

    @Override
    public Customer findById(Integer id) {
        return toEntityDomain.toDomain(customerRepository.findById(id).orElseThrow(() -> new AppException(NotFoundError.NOT_FOUND)));
    }

    @Override
    public void softDelete(Customer customer) {
        customerRepository.save(toEntityDomain.toEntity(customer));
    }

    @Override
    public void saveStatus(Customer customer) {
        customerRepository.save(toEntityDomain.toEntity(customer));
    }
}
