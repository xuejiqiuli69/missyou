/**
 * @作者 leokkzhang
 * @创建时间 2020/4/18 18:34
 */
package com.lin.missyou.exception.http;

public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
