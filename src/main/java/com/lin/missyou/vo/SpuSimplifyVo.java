/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 22:27
 */
package com.lin.missyou.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpuSimplifyVo {
    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private String sketchSpecId;
}
