/**
 * @作者 leokkzhang
 * @创建时间 2020/3/15 16:59
 */
package com.lin.missyou.dto;

import com.lin.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

@Getter
@Builder
@PasswordEqual(min = 6)
public class PersonDTO {
    @Length(min = 2, max = 10, message = "xxx")
    private String name;

    private Integer age;

    private String password1;

    private String password2;

}
