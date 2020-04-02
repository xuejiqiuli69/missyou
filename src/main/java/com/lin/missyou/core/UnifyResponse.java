/**
 * @作者 leokkzhang
 * @创建时间 2020/3/14 22:24
 */
package com.lin.missyou.core;

public class UnifyResponse {
    private int code;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }

    private String message;
    private String request;

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
