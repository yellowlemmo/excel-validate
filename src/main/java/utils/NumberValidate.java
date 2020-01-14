package utils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @ClassName: NumberValidate
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2020/1/13 1:41 PM
 **/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumberValidate.NumberValidateInner.class)
public @interface NumberValidate {

    String message() default "不是数字";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String numberFormat() default "0";

    class NumberValidateInner implements ConstraintValidator<NumberValidate,String> {
        String numberFormat;
        @Override
        public void initialize(NumberValidate constraintAnnotation) {
            this.numberFormat = constraintAnnotation.numberFormat();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            if (numberFormat.equals("") || numberFormat == null){
                return true;
            }
            try{
            Integer.parseInt(value);
            }catch (Exception e){
                return false;
            }
            return true;
        }
    }

}
