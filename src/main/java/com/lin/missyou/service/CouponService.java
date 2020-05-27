/**
 * @作者 leokkzhang
 * @创建时间 2020/4/23 23:40
 */
package com.lin.missyou.service;

import com.lin.missyou.core.enumeration.CouponStatus;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.model.Activity;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.model.UserCoupon;
import com.lin.missyou.repository.ActivityRepository;
import com.lin.missyou.repository.CouponRepository;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserCouponRepository userCouponRepository;

    public List<Coupon> getByCategory(Long cid) {
        Date now = new Date();
        return couponRepository.findByCategory(cid, now);

    }

    public List<Coupon> getWholeStoreCoupons() {
        Date now = new Date();
        return couponRepository.findByWholeStore(true, now);
    }

    public void collectOneCoupon(Long uid, Long couponId) {
        //验证couponId是否合法
        couponRepository.findById(couponId)
                .orElseThrow(() -> new NotFoundException(40003));

        //验证优惠券是否在领取时间范围内
        Activity activity = activityRepository
                .findByCouponListId(couponId)
                .orElseThrow(() -> new NotFoundException(40010));
        Date now = new Date();
        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if (!isIn) {
            throw new ParameterException(40005);
        }
        //验证用户是否已经领取过优惠券(不能重复领取)
        userCouponRepository
                .findFirstByUserIdAndCouponId(uid, couponId)
                .ifPresent(uc ->{throw new ParameterException(40006);});
        //将用户领取的优惠券记录到对应的关系映射表中
        UserCoupon userCouponNew = UserCoupon.builder()
                .userId(uid)
                .couponId(couponId)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        userCouponRepository.save(userCouponNew);
    }


    public List<Coupon> getMyAvailableCoupons(Long uid) {
        Date now = new Date();
        return couponRepository.findMyAvailable(uid, now);
    }

    public List<Coupon> getMyUsedCoupons(Long uid) {
        return couponRepository.findMyUsed(uid);
    }

    public List<Coupon> getMyExpiredCoupons(Long uid) {
        Date now = new Date();
        return couponRepository.findMyExpired(uid, now);
    }

}
