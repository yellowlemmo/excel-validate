package utils;

import entity.Entity;

import java.lang.reflect.Field;

/**
 * @ClassName: ValidateBean
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2020/1/13 2:43 PM
 **/
public class ValidateBean {

    public static String validate(Class clazz,String[] data){
        Entity entity = null;
        try {
            entity = (Entity) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i<data.length;i++){
            try {
                fields[i].setAccessible(true);
                fields[i].set(entity,data[i]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(entity);
        if(validResult.hasErrors()){
            System.err.println(validResult.getErrors());
        }else{
            System.out.println("validate success");
        }


        return null;
    }
}
