package episode4;

/**
 * 编程实现大数的乘法
 *
 * @author 徒有琴
 */
public class Test2 {
    public static void main(String[] args) {
        String a = "689";
        String b = "33";
        System.out.println(689*33);
        char[] large = null;
        char[] small = null;
        if (a.length() >= b.length()) {
            large = a.toCharArray();
            small = b.toCharArray();
        } else {
            large = b.toCharArray();
            small = a.toCharArray();
        }
        int[] multi = new int[a.length() + b.length()];
        for (int j = small.length - 1; j >= 0; j--) {//个位对齐
            for (int i = large.length - 1; i >= 0; i--) {
                int num1 = small[j] - '0';
                int num2 = large[i] - '0';
                multi[large.length - 1 - i + small.length - 1 - j] += num1 * num2;
            }
        }
        for (int i = 0; i < multi.length - 1; i++) {
            if (multi[i] > 9) {
                multi[i + 1] += multi[i] / 10;
                multi[i] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = multi.length - 1; i >= 0; i--) {
            builder.append(multi[i]);
        }
        String result = builder.toString();
        if (result.startsWith("0")) {
            result = result.substring(1);
        }
        System.out.println(result);
    }
}
