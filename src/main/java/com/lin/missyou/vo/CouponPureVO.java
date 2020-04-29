/**
 * @作者 leokkzhang
 * @创建时间 2020/4/21 0:39
 */
package com.lin.missyou.vo;

import com.lin.missyou.model.Coupon;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CouponPureVO {
    private Long id;
//    private Long activityId;
    private String title;
    private Date startTime;
    private Date endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
//    private Integer valitiy;//有效期 新人券是典型场景
    private String remark;
    private Boolean wholeStore;
    private Integer type;

    public CouponPureVO(Coupon coupon) {
        BeanUtils.copyProperties(coupon, this);
    }

    public static List<CouponPureVO> getList(List<Coupon> couponList){
        return couponList.stream()
                .map(CouponPureVO::new)
                .collect(Collectors.toList());
    }
}
