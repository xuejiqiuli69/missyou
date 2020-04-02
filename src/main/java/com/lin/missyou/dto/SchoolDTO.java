/**
 * @作者 leokkzhang
 * @创建时间 2020/3/15 21:25
 */
package com.lin.missyou.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class SchoolDTO {
    @Length(min=2)
    private String schoolName;
}
