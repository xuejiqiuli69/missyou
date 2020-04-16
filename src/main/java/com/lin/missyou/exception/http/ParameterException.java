/**
 * @作者 leokkzhang
 * @创建时间 2020/4/14 23:43
 */
package com.lin.missyou.exception.http;

public class ParameterException extends HttpException{
    public ParameterException(int code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
