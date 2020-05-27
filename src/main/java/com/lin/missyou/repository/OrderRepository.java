/**
 * @作者 leokkzhang
 * @创建时间 2020/5/20 22:54
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
