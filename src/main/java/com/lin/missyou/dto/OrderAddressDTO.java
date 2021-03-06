/**
 * @作者 leokkzhang
 * @创建时间 2020/5/6 22:52
 */
package com.lin.missyou.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderAddressDTO {
    private String userName;
    private String province;
    private String city;
    private String county;
    private String mobile;
    private String nationalCode;
    private String postalCode;
    private String detail;
}
