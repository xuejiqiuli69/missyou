/**
 * @作者 leokkzhang
 * @创建时间 2020/3/11 22:54
 */
package com.lin.missyou.sample.database;

import com.lin.missyou.sample.Iconnect;

public class MySQL implements Iconnect {

    private String ip;
    private Integer port;

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public MySQL() {
    }

    @Override
    public void connect() {
        System.out.println(this.ip + ":" + this.port);
    }
}
