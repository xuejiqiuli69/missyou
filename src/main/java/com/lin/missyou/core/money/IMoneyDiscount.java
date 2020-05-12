/**
 * @作者 leokkzhang
 * @创建时间 2020/5/8 23:23
 */
package com.lin.missyou.core.money;

import java.math.BigDecimal;

public interface IMoneyDiscount {

    BigDecimal discount(BigDecimal original, BigDecimal discount);
}
