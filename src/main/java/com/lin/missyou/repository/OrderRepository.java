/**
 * @作者 leokkzhang
 * @创建时间 2020/5/20 22:54
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByExpiredTimeGreaterThanAndUserIdAndStatus(Date now, Long uid, Integer status, Pageable pageable);
}
