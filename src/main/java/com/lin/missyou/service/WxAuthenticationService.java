/**
 * @作者 leokkzhang
 * @创建时间 2020/4/13 21:25
 */
package com.lin.missyou.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class WxAuthenticationService {

    @Value("${wx.code2session}")
    private String code2SessionUrl;

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;


    public String code2Session(String code) {
        String url = MessageFormat.format(code2SessionUrl, appid, appsecret, code);
        return url;
    }
}
