/**
 * @作者 leokkzhang
 * @创建时间 2020/3/15 23:39
 */
package com.lin.missyou.validators;

import com.lin.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//泛型接口  第一个参数自定义注解类型  第二个参数自定义注解修饰目标的类型
public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {

    private int min;
    private int max;

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {
        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();
        return password1.equals(password2);
    }

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }
}
