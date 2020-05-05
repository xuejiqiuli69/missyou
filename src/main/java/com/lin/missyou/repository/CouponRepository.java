/**
 * @作者 leokkzhang
 * @创建时间 2020/4/23 23:53
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {


    //    @Query(nativeQuery = true,value = "select * FROM coupon\n" +
//            "LEFT JOIN coupon_category cc\n" +
//            "    ON coupon.id = cc.coupon_id\n" +
//            "LEFT JOIN category c\n" +
//            "    ON cc.category_id = c.id\n" +
//            "LEFT JOIN activity a\n" +
//            "    ON coupon.activity_id = a.id\n" +
//            "WHERE c.id = :cid\n" +
//            "AND a.start_time < :now\n" +
//            "AND a.end_time > :now")
    @Query(value = "select c from Coupon c \n" +
            "join " +
            "c.categoryList ca\n" +
            "join " +
            "Activity a on a.id = c.activityId\n" +
            "where ca.id = :cid \n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now")
    List<Coupon> findByCategory(Long cid, Date now);


    @Query(value= "select c from Coupon c \n" +
            "join Activity a on c.activityId = a.id\n" +
            "where c.wholeStore = :isWholeStore\n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now\n")
    List<Coupon> findByWholeStore(Boolean isWholeStore, Date now);


    // coupon  userCoupon user
    @Query(value = "select c from Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on uc.userId = u.id\n" +
            "where uc.status = 1 \n" +
            "and u.id = :uid\n" +
            "and c.startTime < :now\n" +
            "and c.endTime > :now\n" +
            "and uc.orderId is null")
    List<Coupon> findMyAvailable(Long uid, Date now);



    @Query(value = "select c from Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on uc.userId = u.id\n" +
            "where uc.status = 2 \n" +
            "and u.id = :uid\n" +
            "and uc.orderId is not null")
    List<Coupon> findMyUsed(Long uid);


    @Query(value = "select c from Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on uc.userId = u.id\n" +
            "where u.id = :uid\n" +
            "and uc.orderId is null\n" +
            "and uc.status <> 2 \n" +
            "and c.endTime < :now")
    List<Coupon> findMyExpired(Long uid, Date now);

}
