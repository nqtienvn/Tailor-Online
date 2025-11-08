package com.tien.tai.application.mapper;

import com.tien.tai.application.dto.request.CustomerCreateRequest;
import com.tien.tai.application.dto.request.CustomerUpdateRequest;
import com.tien.tai.domain.command.CustomerCreateCmd;
import com.tien.tai.domain.command.CustomerUpdateCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperRequestCommand {
    CustomerCreateCmd from(CustomerCreateRequest customerCreateRequest);
    CustomerUpdateCmd from(CustomerUpdateRequest customerCreateRequest);
}
