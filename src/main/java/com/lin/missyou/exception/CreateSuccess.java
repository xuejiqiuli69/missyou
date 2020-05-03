/**
 * @作者 leokkzhang
 * @创建时间 2020/5/3 16:01
 */
package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

public class CreateSuccess extends HttpException {
    public CreateSuccess(int code){
        this.httpStatusCode = 201;
        this.code = code;
    }
}

//查询成功 200
//创建成功 201
//更新成功 200
//删除成功 200  204的返回的结果为空
