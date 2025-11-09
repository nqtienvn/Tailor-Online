package com.tien.tai.application.service.impl;

import com.tien.tai.application.dto.mapper.AddressMapperDTO;
import com.tien.tai.application.dto.request.AddressCreateRequest;
import com.tien.tai.application.dto.request.AddressUpdateRequest;
import com.tien.tai.application.dto.response.AddressDTO;
import com.tien.tai.application.mapper.handon.MapperToCmd;
import com.tien.tai.application.service.AddressCommandService;
import com.tien.tai.domain.command.AddressCreateCmd;
import com.tien.tai.domain.command.AddressUpdateCmd;
import com.tien.tai.domain.model.Address;
import com.tien.tai.domain.repository.AddressDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressCommandServiceImpl implements AddressCommandService {
    private final AddressMapperDTO addressMapperDTO;
    private final AddressDomainRepository addressDomainRepository;
    private final MapperToCmd mapperRequestCommand;

    @Override
    public List<AddressDTO> getAddressByCustomerId(Integer id) {
        return addressMapperDTO.toDTO(addressDomainRepository.findAddressByCustomerId(id));
    }

    @Override
    public AddressDTO addNewAddress(AddressCreateRequest addressCreateRequest, Integer id) {
        AddressCreateCmd cmd = mapperRequestCommand.from(addressCreateRequest, id);
        Address address = new Address(cmd);
        return addressMapperDTO.toDTO(addressDomainRepository.save(address));
    }

    @Override
    public AddressDTO update(AddressUpdateRequest addressUpdateRequest, Integer id) {
        AddressUpdateCmd cmd = mapperRequestCommand.from(addressUpdateRequest);
        Address address = addressDomainRepository.findById(id);
        address.update(cmd);
        return addressMapperDTO.toDTO(addressDomainRepository.save(address));
    }

    @Override
    public Boolean delete(Integer addressId) {
        return addressDomainRepository.delete(addressId);
    }
}
