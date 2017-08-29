package com.isoft.iwechat.core;

public class RequestFailedException extends RuntimeException {
    private int errorCode;
    private String errorMsg;

    public RequestFailedException(int errorCode, String errorMsg) {
        super("请求出错，错误代码：" + String.valueOf(errorCode) + "，错误原因：" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
