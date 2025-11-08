package com.tien.tai.application.service.impl;

import com.tien.tai.application.dto.mapper.CustomerMapperDTO;
import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.application.dto.response.CustomerDTO;
import com.tien.tai.application.mapper.MapperRequestCommand;
import com.tien.tai.application.service.CustomerCommandService;
import com.tien.tai.domain.command.CustomerCreateCmd;
import com.tien.tai.domain.command.CustomerUpdateCmd;
import com.tien.tai.domain.model.Customer;
import com.tien.tai.domain.repository.CustomerDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {
    private final MapperRequestCommand mapperRequestCommand;
    private final CustomerDomainRepository customerDomainRepository;
    private final CustomerMapperDTO customerMapperDTO;
    @Override
    public CustomerDTO create(CustomerCreateRequest request) {
        CustomerCreateCmd cmd = mapperRequestCommand.from(request);
        Customer customer = new Customer(cmd);
        return customerMapperDTO.toDTO(customerDomainRepository.save(customer));
    }

    @Override
    public CustomerDTO update(CustomerUpdateRequest request, Integer id) {
        CustomerUpdateCmd cmd = mapperRequestCommand.from(request);
        Customer domainFind = customerDomainRepository.findById(id);
        domainFind.update(cmd);
        return customerMapperDTO.toDTO(customerDomainRepository.save(domainFind));
    }

    @Override
    public void inActive(Integer id) {
        Customer domainFind = customerDomainRepository.findById(id);
        domainFind.inActive();
        customerDomainRepository.softDelete(domainFind);

    }

    @Override
    public void active(Integer id) {
        Customer domainFind = customerDomainRepository.findById(id);
        domainFind.active();
        customerDomainRepository.softDelete(domainFind);
    }
}
