/**
 * @作者 leokkzhang
 * @创建时间 2020/3/23 22:41
 */
package com.lin.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @JsonIgnore
    @Column(insertable = false,updatable = false)
    private Date createTime;

    @JsonIgnore
    @Column(insertable = false,updatable = false)
    private Date updateTime;

    @JsonIgnore
    private Date deleteTime;
}
