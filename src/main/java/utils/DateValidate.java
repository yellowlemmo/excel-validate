package utils;

import org.apache.commons.lang3.time.DateUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.text.ParseException;
import java.util.Date;

/**
 * @ClassName: DateValidate
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2020/1/13 11:57 AM
 **/

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {DateValidate.DateValidatorInner.class})
public @interface DateValidate {

    String message() default "日期格式不匹配{dateFormat}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String dateFormat() default "yyyy-MM-dd HH:mm:ss";


    class DateValidatorInner implements ConstraintValidator<DateValidate,String> {
        private String dateFormat;
        @Override
        public void initialize(DateValidate constraintAnnotation) {
            this.dateFormat = constraintAnnotation.dateFormat();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            if (value == null) {
                return true;
            }
            if("".equals(value)){
                return true;
            }
            try {
                Date date = DateUtils.parseDate(value, dateFormat);
                return date != null;
            } catch (ParseException e) {
                return false;
            }
        }
    }

}
