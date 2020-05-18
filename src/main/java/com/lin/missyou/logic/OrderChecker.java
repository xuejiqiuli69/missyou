/**
 * @作者 leokkzhang
 * @创建时间 2020/5/7 23:42
 */
package com.lin.missyou.logic;

import com.lin.missyou.bo.SkuOrderBO;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.dto.SkuInfoDTO;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.model.OrderSku;
import com.lin.missyou.model.Sku;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderChecker {

    private OrderDTO orderDTO;
    private List<Sku> serverSkuList;
    private CouponChecker couponChecker;

    private Integer maxSkuLimit;

    @Getter
    private List<OrderSku> orderSkuList = new ArrayList<>();

    public OrderChecker(OrderDTO orderDTO, List<Sku> serverSkuList,
                        CouponChecker couponChecker, Integer maxSkuLimit) {
        this.orderDTO = orderDTO;
        this.serverSkuList = serverSkuList;
        this.couponChecker = couponChecker;
        this.maxSkuLimit = maxSkuLimit;
    }

    public String getLeaderImg(){
        return serverSkuList.get(0).getImg();
    }

    public String getLeaderTitle(){
        return serverSkuList.get(0).getTitle();
    }

    public Integer getTotalCount(){
        return orderDTO.getSkuInfoList()
                .stream()
                .map(SkuInfoDTO::getCount)
                .reduce(Integer::sum)
                .orElse(0);
    }

    //校验数据
    /*
     *1.orderTotalPrice serverTotalPrice
     *2.sku下架
     *3.sku售罄(未必有效  但预检测合理)
     *4.订单中的sku超过了最大库存
     *5.订单sku数量超出了最大规定购买数量
     *6.优惠券检验*/

    //为数据库写入准备数据
    public void isOK() {

        BigDecimal serverTotalPrice = new BigDecimal("0");
        List<SkuOrderBO> skuOrderBOList = new ArrayList<>();

        skuNotOnSale(orderDTO.getSkuInfoList().size(), serverSkuList.size());

        for (int i = 0; i < serverSkuList.size(); i++) {
            Sku sku = serverSkuList.get(i);
            SkuInfoDTO skuInfoDTO = orderDTO.getSkuInfoList().get(i);
            containsSoldOutSku(sku);
            beyondSkuStock(sku, skuInfoDTO);
            beyondMaxSkuLimit(skuInfoDTO);

            serverTotalPrice.add(calculateServerTotalPrice(sku, skuInfoDTO));
            skuOrderBOList.add(new SkuOrderBO(sku, skuInfoDTO));
            orderSkuList.add(new OrderSku(sku, skuInfoDTO));
        }

        totalPriceIsOk(orderDTO.getTotalPrice(), serverTotalPrice);

        if (couponChecker != null) {
            couponChecker.isOk();
            couponChecker.canBeUsed(skuOrderBOList, serverTotalPrice);
            couponChecker.finalTotalPriceIsOk(orderDTO.getFinalTotalPrice(), serverTotalPrice);
        }

    }


    private void totalPriceIsOk(BigDecimal orderTotalPrice, BigDecimal serverTotalPrice) {
        if (orderTotalPrice.compareTo(serverTotalPrice) != 0) {
            throw new ParameterException(50005);
        }
    }


    private BigDecimal calculateServerTotalPrice(Sku sku, SkuInfoDTO skuInfoDTO) {
        if (skuInfoDTO.getCount() <= 0) {
            throw new ParameterException(50007);
        }
        return sku.getAutualPrice().multiply(new BigDecimal(skuInfoDTO.getCount()));
    }

    //校验是否有下架sku
    private void skuNotOnSale(int count1, int count2) {
        if (count1 != count2) {
            throw new ParameterException(50002);
        }

    }

    //判断sku是否售罄
    private void containsSoldOutSku(Sku sku) {
        if (sku.getStock() == 0) {
            throw new ParameterException(50001);
        }
    }

    //判断是否存在超卖情况
    private void beyondSkuStock(Sku sku, SkuInfoDTO skuInfoDTO) {
        if (sku.getStock() < skuInfoDTO.getCount()) {
            throw new ParameterException(50003);
        }
    }

    //判断订单sku数量超出了最大规定购买数量
    private void beyondMaxSkuLimit(SkuInfoDTO skuInfoDTO) {
        if (skuInfoDTO.getCount() > maxSkuLimit) {
            throw new ParameterException(50004);
        }
    }
}
