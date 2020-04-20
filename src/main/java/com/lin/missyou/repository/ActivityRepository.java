/**
 * @作者 leokkzhang
 * @创建时间 2020/4/21 0:18
 */
package com.lin.missyou.repository;

import com.lin.missyou.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findOneByName(String name);
}
