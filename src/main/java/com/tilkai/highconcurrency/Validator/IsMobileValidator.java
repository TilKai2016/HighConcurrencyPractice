package com.tilkai.highconcurrency.Validator;

import com.tilkai.highconcurrency.util.ValidatorUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Note: 实现ConstraintValidator<?, ?>, <p>ConstraintValidator的两个参数分别为注解, 以及注解标注的字段类型.</p>
 *
 * @author tilkai
 * @date 2018-09-07 下午5:23
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {

        required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtils.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtils.isMobile(value);
            }
        }
    }
}
