import entity.Entity;
import org.junit.Test;
import utils.ValidateBean;

/**
 * @ClassName: ValidateTestCase
 * @DESCRIPT: TODO
 * @AUTHOR: cuizhichao
 * @DATA: 2020/1/14 10:05 AM
 **/
public class ValidateTestCase {
    @Test
    public void test(){
        String[] entities = new String[]{"a","b","c","d"};
        ValidateBean.validate(Entity.class,entities);    }
}
