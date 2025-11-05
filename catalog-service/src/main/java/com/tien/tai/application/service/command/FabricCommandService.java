package com.tien.tai.application.service.command;


import com.tien.tai.application.dto.request.FabricRequest;
import com.tien.tai.application.dto.response.FabricResponse;

public interface FabricCommandService {
    FabricResponse create(FabricRequest fabricRequest);

    FabricResponse update(FabricRequest fabricRequest, Integer id);

    void softDelete(Integer id);

    void inActive(Integer id);

    void active(Integer id);
}
