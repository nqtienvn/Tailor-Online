package com.tien.tai.application.mapper.handon;

import com.tien.tai.application.dto.request.CustomerSearchRequest;
import com.tien.tai.domain.query.CustomerSearchQuery;
import com.tien.tai.infrastructor.persistence.model.Gender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "MapperQuery")
public class MapperToQuery {
    public CustomerSearchQuery toQuery(CustomerSearchRequest request) {
        log.debug(request.getFullName());
        return CustomerSearchQuery.builder()
                .pageSize(request.getPageSize())
                .email(request.getEmail())
                .dateOfBirth(request.getDateOfBirth())
                .gender(Gender.fromString(request.getGender()))
                .fullName(request.getFullName())
                .isTemporary(request.getIsTemporary())
                .phoneNumber(request.getPhoneNumber())
                .pageIndex(request.getPageIndex())
                .sortBy(request.getSortBy())
                .build();
    }
}
