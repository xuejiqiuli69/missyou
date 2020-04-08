/**
 * @作者 leokkzhang
 * @创建时间 2020/4/8 23:38
 */
package com.lin.missyou.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThemePureVO {
    private Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;
}
