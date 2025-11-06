package com.tien.common.exception;

import com.tien.common.dto.response.ApiResponse;
import com.tien.common.exception.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse> generateAppException(AppException exception) {
        ErrorResponse errorResponse = exception.getErrorCode();
        ApiResponse apiResponse = ApiResponse.builder()
                .code(errorResponse.getCode())
                .message(errorResponse.getMessage())
                .status(errorResponse.getStatus())
                .build();
        return ResponseEntity.status(errorResponse.getStatus()).body(apiResponse);
    }
}
