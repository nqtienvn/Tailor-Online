package com.tien.tai.application.service.impl;

import com.tien.common.dto.response.PageDTO;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.application.dto.mapper.CustomerMapperDTO;
import com.tien.tai.application.dto.request.CustomerSearchRequest;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.application.mapper.handon.MapperToQuery;
import com.tien.tai.application.service.CustomerQueryService;
import com.tien.tai.domain.model.Customer;
import com.tien.tai.domain.query.CustomerSearchQuery;
import com.tien.tai.domain.repository.CustomerDomainRepository;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import com.tien.tai.infrastructor.persistence.repository.CustomerRepositoryCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final ToEntityDomain<CustomerEntity, Customer> toEntityDomain;
    private final MapperToQuery mapperToQuery;
    private final CustomerMapperDTO customerMapperDTO;
    private final CustomerRepositoryCustomer customerRepositoryCustomer;
    private final CustomerDomainRepository customerDomainRepository;

    @Override
    public PageDTO<CustomerDTO> search(CustomerSearchRequest request) {
        CustomerSearchQuery searchQuery = this.mapperToQuery.toQuery(request);
        Long total = this.customerRepositoryCustomer.count(searchQuery);
        if (Objects.equals(total, 0L)) {
            return PageDTO.empty();
        }
        List<Customer> customers = this.toEntityDomain.toDomain(this.customerRepositoryCustomer.search(searchQuery));
        List<CustomerDTO> customerDtos = this.customerMapperDTO.toDTO(customers);
        this.customerDomainRepository.enrichDTO(customerDtos);
        return new PageDTO<>(customerDtos, request.getPageIndex(), request.getPageSize(), total);
    }
}
