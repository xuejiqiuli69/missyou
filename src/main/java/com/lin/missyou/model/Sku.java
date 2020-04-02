/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 22:02
 */
package com.lin.missyou.model;

import com.lin.missyou.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity{
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    private Long categoryId;
    private Long rootCategoryId;
    private String specs;

    @Convert(converter = MapAndJson.class)
    private Map<String,Object> test;
    private String code;
    private Long stock;
}
