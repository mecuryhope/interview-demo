package episode2;

import org.junit.Test;

/**
 * @author 徒有琴
 */
public class ExceptionTest {
    @Test
    public void test1() {
        try {
            //业务代码
            Integer a=null;
            System.out.println(a+1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
