/**
 * @作者 leokkzhang
 * @创建时间 2020/4/3 0:10
 */
package com.lin.missyou.exception.http;

public class ServerErrorException extends HttpException {
    public ServerErrorException(int code){
        this.httpStatusCode = 500;
        this.code = code;
    }
}
