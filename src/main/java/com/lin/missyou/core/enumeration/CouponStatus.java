package com.lin.missyou.core.enumeration;

import java.util.stream.Stream;

public enum CouponStatus {

    AVAILABLE(1,"可以使用,未过期"),
    USED(2,"已使用"),
    EXPIRED(3,"未使用,已过期");

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public static CouponStatus toType(Integer value) {
        return Stream.of(CouponStatus.values())
                .filter(c -> c.getValue() == value)
                .findAny()
                .orElse(null);
    }

    CouponStatus(Integer value, String description){
        this.value = value;
    }
}
