/**
 * @作者 leokkzhang
 * @创建时间 2020/3/30 0:32
 */
package com.lin.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    private Long total;//总条数
    private Integer count;//当前分页记录数
    private Integer page;//当前页码
    private Integer totalPage;//总页码
    private List<T> items;

    public Paging(Page<T> pageT){
        initPageParameters(pageT);
        items = pageT.getContent();
    }

    protected void initPageParameters(Page<T> pageT){
        total = pageT.getTotalElements();
        count = pageT.getSize();
        page = pageT.getNumber();
        totalPage = pageT.getTotalPages();
    }
}