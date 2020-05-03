/**
 * @作者 leokkzhang
 * @创建时间 2020/5/3 16:05
 */
package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

public class DeleteSuccess extends HttpException {
    public DeleteSuccess(int code){
        this.httpStatusCode = 204; //返回中没有内容
        this.code = code;
    }
}
