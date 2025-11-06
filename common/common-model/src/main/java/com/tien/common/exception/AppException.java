package com.tien.common.exception;

import com.tien.common.exception.error.ErrorResponse;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
  private ErrorResponse errorCode;
  public AppException(ErrorResponse errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
