package episode3;

/**
 * @author 徒有琴
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer num1=new Integer(1000);
        Integer num2=new Integer(1000);
        num2++;
        System.out.println(num1==num2);
        System.out.println(num1.equals(num2));
        System.out.println(num1.intValue()==num2.intValue());

    }
}
