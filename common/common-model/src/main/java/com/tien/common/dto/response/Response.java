package com.tien.common.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tien.common.exception.error.ErrorCodeClient;
import com.tien.common.exception.error.ResponseError;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Response<T> implements Serializable {

    protected T data;
    private boolean success;
    private int code;
    private String message;
    private long timestamp;
    private String status; // only GL

    @JsonIgnore private RuntimeException exception;

    public Response() {
        timestamp = Instant.now().toEpochMilli();
        success = true;
        code = 200;
        status = ErrorCodeClient.SUCCESS.name();
    }

    public static <T> Response<T> of(T res) {
        Response<T> response = new Response<>();
        response.data = res;
        response.success();
        return response;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.success();
        return response;
    }

    public static <T> Response<T> fail(RuntimeException exception) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setStatus(ErrorCodeClient.FAIL.name());
        response.setException(exception);
        return response;
    }

    public static <T> Response<T> fail(String message, RuntimeException exception) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setStatus(ErrorCodeClient.FAIL.name());
        response.setException(exception);
        response.setMessage(message);
        return response;
    }

    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setStatus(ErrorCodeClient.FAIL.name());
        return response;
    }

    public Response<T> success() {
        success = true;
        code = 200;
        status = ErrorCodeClient.SUCCESS.name();
        return this;
    }

    public Response<T> data(T res) {
        data = res;
        return this;
    }

    public Response<T> success(String message) {
        success = true;
        this.message = message;
        code = 200;
        status = ErrorCodeClient.SUCCESS.name();
        return this;
    }

    public Response<T> fail(String message, ResponseError responseError) {
        success = false;
        code = responseError.getCode();
        status = ErrorCodeClient.FAIL.name();
        if (StringUtils.hasText(message)) {
            this.message = message;
        } else {
            this.message = responseError.getMessage();
        }
        return this;
    }

    public Response<T> fail(Exception ex, ResponseError responseError) {
        success = false;
        code = responseError.getCode();
        status = ErrorCodeClient.FAIL.name();
        this.message = ex.getMessage();
        return this;
    }

    public T getData() {
        if (exception != null) {
            throw exception;
        }
        return data;
    }

    public boolean isSuccess() {
        if (exception != null) {
            throw exception;
        }
        return success;
    }

    @Override
    public String toString() {
        return "Response {"
                + "data="
                + data
                + ", success="
                + success
                + ", status="
                + status
                + ", code="
                + code
                + ", message='"
                + message
                + '\''
                + ", timestamp="
                + timestamp
                + ", exception="
                + exception
                + '}';
    }
}
