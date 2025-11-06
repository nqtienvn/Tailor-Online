package com.tien.tai.application.service.command.impl;

import com.tien.tai.application.dto.mapper.UserMapperDTO;
import com.tien.tai.application.dto.request.UserRequest;
import com.tien.tai.application.dto.response.UserRespose;
import com.tien.tai.application.mapper.UserCommandMapper;
import com.tien.tai.application.service.command.UserCommandService;
import com.tien.tai.domain.command.UserCmd;
import com.tien.tai.domain.model.UserDomain;
import com.tien.tai.domain.repository.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserCommandMapper userCommandMapper;
    private final UserDomainRepository userDomainRepository;
    private final UserMapperDTO userMapperDTO;

    @Override
    public UserRespose create(UserRequest userRequest){

        UserCmd userCmd = userCommandMapper.from(userRequest);
        UserDomain domainUser = UserDomain.create(userCmd);
        UserDomain saveDomainUser = userDomainRepository.save(domainUser);
        return userMapperDTO.from(saveDomainUser);

    }
}
