/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 22:01
 */
package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpuImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;
}
