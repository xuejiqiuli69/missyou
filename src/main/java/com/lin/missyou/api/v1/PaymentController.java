/**
 * @作者 leokkzhang
 * @创建时间 2020/5/31 15:29
 */
package com.lin.missyou.api.v1;

import com.lin.missyou.core.interceptors.ScopeLevel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("payment")
@RestController
public class PaymentController {

    @PostMapping("/pay/order/{id}")
    @ScopeLevel
    public void preWxOrder(@PathVariable(name = "id") Long oid) {

    }
}
