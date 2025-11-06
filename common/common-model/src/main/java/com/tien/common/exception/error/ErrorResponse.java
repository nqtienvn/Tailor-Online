package com.tien.common.exception.error;

public interface ErrorResponse {


    String getName();

    String getMessage();

    int getStatus();

    default Integer getCode() {
        return 0;
    }
}
