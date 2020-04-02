/**
 * @作者 leokkzhang
 * @创建时间 2020/3/14 22:10
 */
package com.lin.missyou.exception.http;

public class NotFoundException extends HttpException {
    public NotFoundException(int code) {
        this.httpStatusCode = 404;
        this.code = code;
    }
}
