package com.tien.tai.application.service.command;


import com.tien.tai.application.dto.request.ProductRequest;
import com.tien.tai.application.dto.response.ProductResponse;

public interface ProductCommandService {
    ProductResponse create(ProductRequest productRequest);

    ProductResponse update(ProductRequest productRequest, Integer id);

    void softDelete(Integer id);

    void inActive(Integer id);

    void active(Integer id);
}
