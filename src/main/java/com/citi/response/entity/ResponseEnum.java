package com.citi.response.entity;


public enum ResponseEnum {
    NULL_PARAMS(1,"null param"),
    ILLEGAL_PARAMS(2,"illegal param"),
    MISS_TOKEN(3, "miss token"),
    WRONG_PASS(4, "password is wrong"),
    EXPIRE_TOKEN(5, "token is expire"),
    INVALID_TOKEN(6, "token is invalid"),
    NO_SUCH_INDEX(7, "no such index"),
    NOT_LOG(8,"please login"),
    LOGIN_FAIL(9,"login again"),
    UPLOAD_FAIL(10,"upload fail"),
    FILE_TYPE_ERROR(11,"file type error"),
    USER_INSERT_FAIL(12,"user insert fail"),
    USER_MODIFY_FAIL(13,"user modify fail"),
    USER_DELETE_FAIL(14,"user delete fail"),
    CASH_FAIL(15,"cash not enough"),
    QTY_FAIL(16,"quantity not enough"),
    SUCCESS(200,"success");
    int code;
    String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
