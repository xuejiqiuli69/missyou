package com.lin.missyou.core.enumeration;

public enum CouponStatus {

    AVAILABLE(1,"可以使用,未过期"),
    USED(2,"已使用"),
    EXPIRED(3,"未使用,已过期");

    private Integer value;

    public Integer getValue() {
        return value;
    }

    CouponStatus(Integer value, String description){
        this.value = value;
    }
}
