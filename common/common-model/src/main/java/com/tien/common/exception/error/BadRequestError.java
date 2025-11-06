package com.tien.common.exception.error;

import lombok.Getter;

@Getter
public enum BadRequestError implements ErrorResponse{
    INVALID_INPUT(40000001, "Invalid input : {0}"),
    INVALID_ACCEPT_LANGUAGE(40000002, "Invalid value for request header Accept-Language: {0}"),
    MISSING_PATH_VARIABLE(40000003, "Missing path variable"),
    PATH_INVALID(40000004, "Path is invalid"),
    UNDEFINED(40000005, ""),
    FILE_SIZE_EXCEEDED(40000006, "File size exceeds the limit"),
    CAN_NOT_APPROVE_WITH_APPROVAL_STATUS_OTHER_THAN_WAIT_APPROVE_STATUS(
            40000007, "Can not approve with approval status other than wait approve status"),
    CAN_NOT_REJECT_WITH_APPROVAL_STATUS_OTHER_THAN_WAIT_APPROVE_STATUS(
            40000008, "Can not reject with approval status other than wait approve status"),
    CAN_NOT_CANCEL_WITH_APPROVAL_STATUS_OTHER_THAN_WAIT_APPROVE_STATUS(
            40000009, "Can not cancel with approval status other than wait approve status"),
    CAN_NOT_WAIT_APPROVE_WITH_APPROVAL_STATUS_OTHER_THAN_NEW_STATUS(
            40000010, "Can not wait approve with approval status other than wait cancel status"),
    CAN_NOT_DELETE_IN_APPROVED_OR_WAIT_APPROVE(
            40000011, "Can not delete in approved or wait approve"),
    RECORD_IS_BEING_UPDATED(40000012, "The record is being updated. Please wait a minute"),
    CAN_NOT_BACK_WAIT_APPROVE_WITH_APPROVAL_STATUS_OTHER_THAN_APPROVED_STATUS(
            40000013, "Can not back wait approve with approval status other than approved status"),
    CAN_NOT_BACK_NEW_WITH_APPROVAL_STATUS_OTHER_THAN_APPROVED_STATUS(
            40000013, "Can not back new with approval status other than approved status"),
    ;

    private final Integer code;
    private final String message;

    BadRequestError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public int getStatus() {
        return 400;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
