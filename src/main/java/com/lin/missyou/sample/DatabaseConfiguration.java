/**
 * @作者 leokkzhang
 * @创建时间 2020/3/11 22:59
 */
package com.lin.missyou.sample;

import com.lin.missyou.sample.database.MySQL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DatabaseConfiguration {

//    @Value("${mysql.ip}")
    private String ip;

//    @Value("${mysql.port}")
    private Integer port;

//    @Bean
    public Iconnect mysql() {
        return new MySQL(this.ip, this.port);
    }
}
