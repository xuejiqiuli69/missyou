/**
 * @作者 leokkzhang
 * @创建时间 2020/4/12 21:12
 */
package com.lin.missyou.api.v1;

import com.lin.missyou.dto.TokenGetDTO;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.service.WxAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/token")
@RestController
public class TokenController {

    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO userData) {
        Map<String, String> map = new HashMap<>();
        String token = null;
        switch (userData.getType()){
            case USER_WX:
                wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_Email:
                //留待自己写 注意加解密
                break;
            default:
                throw new NotFoundException(10003);
        }
        return null;
    }
}
