/**
 * @作者 leokkzhang
 * @创建时间 2020/5/3 14:57
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
    Optional<UserCoupon> findFirstByUserIdAndCouponIdAndStatus(Long uid, Long couponId, int status);

    Optional<UserCoupon> findFirstByUserIdAndCouponId(Long uid, Long couponId);

    @Modifying
    @Query("update UserCoupon uc\n" +
            "set uc.orderId = :oid,uc.status = 2\n" +
            "where uc.couponId = :couponId \n" +
            "and uc.userId = :uid\n" +
            "and uc.status = 1 \n" +
            "and uc.orderId is null")
    int writeOff(Long couponId, Long oid, Long uid);
}
