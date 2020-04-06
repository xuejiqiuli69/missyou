/**
 * @作者 leokkzhang
 * @创建时间 2020/4/6 18:07
 */
package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class CategoryPureVO {
    private Long id;
    private String name;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;

    public CategoryPureVO(Category category) {
        //只有当源和目标的字段名称完全相同时可用，且属于浅拷贝
        BeanUtils.copyProperties(category, this);
    }
}
