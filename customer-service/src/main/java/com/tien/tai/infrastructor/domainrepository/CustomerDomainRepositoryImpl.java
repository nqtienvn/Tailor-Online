package com.tien.tai.infrastructor.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.application.dto.mapper.entittyToResponeMapper.AddressEntityMapper;
import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.domain.model.Customer;
import com.tien.tai.domain.repository.CustomerDomainRepository;
import com.tien.tai.infrastructor.persistence.model.AddressEntity;
import com.tien.tai.infrastructor.persistence.model.CustomerEntity;
import com.tien.tai.infrastructor.persistence.repository.AddressRepository;
import com.tien.tai.infrastructor.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CustomerDomainRepositoryImpl implements CustomerDomainRepository {
    private final ToEntityDomain<CustomerEntity, Customer> toEntityDomain;
    private final CustomerRepository customerRepository;
    private final AddressEntityMapper addressEntityMapper;
    private final AddressRepository addressRepository;

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

    @Override
    public void enrichDTO(List<CustomerDTO> customerDTOS) {
        if (customerDTOS == null || customerDTOS.isEmpty()) return;

        List<Integer> customerId = customerDTOS.stream()
                .map(CustomerDTO::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        List<AddressEntity> addressEntities = addressRepository.findAddressEntityByCustomerIdIn(customerId);
        List<AddressDTO> addressDTOS = addressEntityMapper.toAddressDTOs(addressEntities);
        Map<Integer, List<AddressDTO>> customerWithAddressDtoMap = addressDTOS.stream()
                .collect(Collectors.groupingBy(AddressDTO::getCustomerId));

        customerDTOS.forEach(customerDTO -> customerDTO.setAddresses(
                customerWithAddressDtoMap.getOrDefault(customerDTO.getId(), List.of())
        ));
    }
}
