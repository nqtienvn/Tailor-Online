package com.tien.tai.application.service;

import com.tien.tai.application.dto.request.AddressCreateRequest;
import com.tien.tai.application.dto.request.AddressUpdateRequest;
import com.tien.tai.application.dto.response.AddressDTO;

import java.util.List;

public interface AddressCommandService {
    List<AddressDTO> getAddressByCustomerId(Integer id);

    AddressDTO addNewAddress(AddressCreateRequest addressCreateRequest, Integer customerId);

    AddressDTO update(AddressUpdateRequest addressUpdateRequest, Integer addressId);

    Boolean delete(Integer addressId);
}
