/**
 * @作者 leokkzhang
 * @创建时间 2020/5/8 23:25
 */
package com.lin.missyou.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfUpRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {

        BigDecimal actual = original.multiply(discount);
        BigDecimal finalMoney = actual.setScale(2, RoundingMode.HALF_UP);
        return finalMoney;
    }
}
