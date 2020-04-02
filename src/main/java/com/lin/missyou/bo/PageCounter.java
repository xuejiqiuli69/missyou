/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 23:27
 */
package com.lin.missyou.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageCounter {
    private Integer page;
    private Integer count;
}
