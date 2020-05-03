/**
 * @作者 leokkzhang
 * @创建时间 2020/5/3 16:04
 */
package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

public class UpdateSuccess extends HttpException {
    public UpdateSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
