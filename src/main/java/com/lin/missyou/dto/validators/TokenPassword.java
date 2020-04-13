package com.lin.missyou.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//该直接被javadoc记录
@Documented
//指定被它注解的注解保持多久
@Retention(RetentionPolicy.RUNTIME)
//设定注解的使用范围
@Target({ElementType.TYPE,ElementType.FIELD})
//指定注解的处理逻辑类
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    int min() default 6;

    int max() default 32;

    String message() default "字段不符合要求";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
