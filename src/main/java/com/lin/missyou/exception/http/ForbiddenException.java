/**
 * @作者 leokkzhang
 * @创建时间 2020/3/14 22:12
 */
package com.lin.missyou.exception.http;

public class ForbiddenException extends HttpException{
    public ForbiddenException(int code){
        this.httpStatusCode = 403;
        this.code = code;
    }
}
