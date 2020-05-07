/**
 * @作者 leokkzhang
 * @创建时间 2020/5/7 23:11
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkuRepository extends JpaRepository<Sku, Long> {

    List<Sku> findAllByIdIn(List<Long> ids);
}
