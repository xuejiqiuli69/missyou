/**
 * @作者 leokkzhang
 * @创建时间 2020/5/6 23:21
 */
package com.lin.missyou.service;

import com.lin.missyou.core.enumeration.OrderStatus;
import com.lin.missyou.core.money.IMoneyDiscount;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.dto.SkuInfoDTO;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.logic.CouponChecker;
import com.lin.missyou.logic.OrderChecker;
import com.lin.missyou.model.*;
import com.lin.missyou.repository.CouponRepository;
import com.lin.missyou.repository.OrderRepository;
import com.lin.missyou.repository.SkuRepository;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private SkuService skuService;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private UserCouponRepository userCouponRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SkuRepository skuRepository;

    @Autowired
    private IMoneyDiscount iMoneyDiscount;

    @Value("${missyou.order.max-sku-limit}")
    private int maxSkuLimit;

    @Value("${missyou.order.pay-time-limit}")
    private Integer payTimeLimit;


    @Transactional
    public Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker) {

        String orderNo = OrderUtil.makeOrderNo();
        Calendar now = Calendar.getInstance();


        Order order = Order.builder()
                .orderNo(orderNo)
                .totalPrice(orderDTO.getTotalPrice())
                .finalTotalPrice(orderDTO.getFinalTotalPrice())
                .userId(uid)
                .totalCount(orderChecker.getTotalCount().longValue())
                .snapImg(orderChecker.getLeaderImg())
                .snapTitle(orderChecker.getLeaderTitle())
                .status(OrderStatus.UNPAID.value())
                .expiredTime(CommonUtil.addSomeSeconds(now,payTimeLimit).getTime())
                .build();
        order.setSnapAddress(orderDTO.getAddress());
        order.setSnapItems(orderChecker.getOrderSkuList());
        orderRepository.save(order);
        //reduceStock
        reduceStock(orderChecker);
        //核销优惠券
        if(orderDTO.getCouponId() != null){
            this.writeOffCoupon(orderDTO.getCouponId(),order.getId(),uid);
        }
        //加入延迟消息队列
        return order.getId();
    }


    private void writeOffCoupon(Long couponId, Long oid, Long uid) {
        int result = userCouponRepository.writeOff(couponId, oid, uid);
        if (result != 1) {
            throw new ForbiddenException(40012);
        }
    }

    private void reduceStock(OrderChecker orderChecker) {
        List<OrderSku> orderSkuList = orderChecker.getOrderSkuList();
        for (OrderSku orderSKu : orderSkuList) {
            int result = skuRepository.reduceStock(orderSKu.getId(), orderSKu.getCount().longValue());
            if (result != 1) {
                throw new ParameterException(50003);
            }
        }
    }

    public OrderChecker isOk(Long uid, OrderDTO orderDTO) {
        if (orderDTO.getFinalTotalPrice().compareTo(new BigDecimal("0")) <= 0) {
            throw new ParameterException(50011);
        }

        List<Long> skuIdList = orderDTO.getSkuInfoList()
                .stream()
                .map(SkuInfoDTO::getId)
                .collect(Collectors.toList());

        //获取实时sku信息
        List<Sku> skuList = skuService.getSkuListByIds(skuIdList);

        //
        Long couponId = orderDTO.getCouponId();
        CouponChecker couponChecker = null;
        if (couponId != null) {
            //当前优惠券不存在
            Coupon coupon = couponRepository.findById(couponId)
                    .orElseThrow(() -> new NotFoundException(40004));
            //当前用户并未领取该优惠券
            UserCoupon userCoupon = userCouponRepository.findFirstByUserIdAndCouponIdAndStatus(uid, couponId, 1)
                    .orElseThrow(() -> new NotFoundException(50006));
            couponChecker = new CouponChecker(coupon, iMoneyDiscount);
        }
        OrderChecker orderChecker = new OrderChecker(orderDTO, skuList, couponChecker, maxSkuLimit);
        orderChecker.isOK();
        return orderChecker;

    }
}
