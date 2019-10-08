package episode4;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串相关
 *
 * @author 徒有琴
 */
public class Test3 {


    @Test//出现最多的字符
    public void test1_1() {
        String str = "abcdefgabcedfgabcceedfaaaaaaa";
        //统计每一个字符出现的次数
        char res = str.charAt(0);
        int max = 0;//最多出现了多少次
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == temp) {//计算temp出现了多少次
                    count++;
                }
            }
            if (count >= max) {
                max = count;
                res = temp;
            }
        }
        System.out.println(res + "出现次数最多：" + max);
    }

    @Test
    public void test1_2() {//统计每个字符出现的次数  出现最多的 出现最少的
        String str = "abcddddddddddddddefgabcedfgabcceedfaaaaaaa";
        char res = str.charAt(0);
        int max = 0;//最多出现了多少次
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count = map.get(c);
            if (count == null) {//字符没有出现过
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
            if (count > max) {
                res = c;
                max = count;
            }
        }
        System.out.println(res + "出现次数最多：" + max);
    }


    @Test
    public void test2_1() {
        String str = "abbcacba";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {//已经存在了
                System.out.println(str.charAt(i));
                break;
            }
        }
//        Map<Character, Object> map = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (map.containsKey(str.charAt(i))) {//已经存在了
//                System.out.println(str.charAt(i));
//                break;
//            } else {
//                map.put(str.charAt(i), 1);
//            }
//        }
    }


    @Test
    public void test3_1() {
        String str = "abcfabcdeab";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.get(str.charAt(i));
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(str.charAt(i), count);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    @Test
    public void test3_2() {
        String str = "abcfabcdeab";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.println(c);
                break;
            }
        }
    }


    @Test
    public void test4() {
        int[] count = new int[10];
        String mobile = "13724539987";
        for (int i = 0; i < mobile.length(); i++) {//桶排序
            char c = mobile.charAt(i);
            count[c - '0']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println(i + "出现了" + count[i]);
            }
        }
    }


    @Test
    public void test5() {
        String str = "人ABC们DEF";
        int count = 9;
        int sum = 0;//已经截取了多少
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int len = String.valueOf(str.charAt(i)).getBytes().length;//每个字符的字节数
            if (sum + len <= count) {
                sum += len;
                builder.append(str.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(builder.toString());
    }


    @Test
    public void test6() {
        String str = "<p id=\"text\">abcdefg</p>";
//        String reg = "efg";
//        int index = str.indexOf(reg);
//        String target = str.substring(index, index + reg.length());
        String reg = "(.*)(efg)(.*)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }

    //设计一种反转字符串的算法，例如源字符串为src="abddefg",反转后字符串ded="gfeddba"
    @Test
    public void test7() {
        String src = "abddefg";
        char[] chars = src.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        System.out.println(new String(chars));


//        StringBuilder builder=new StringBuilder(src);
//        System.out.println(builder.reverse());

//        String des="";
//        for(int i=src.length()-1;i>=0;i--){
//            des+=src.charAt(i);
//        }
//        System.out.println(des);
    }

    @Test
    public void test8() {
        System.out.println(inverseSentence("I love the game", " "));
    }


    String inverseSentence(String in, String sep) {
        String[] arrs = in.split(sep);
        StringBuilder builder = new StringBuilder();
        for (int i = arrs.length - 1; i >= 0; i--) {
            builder.append(arrs[i]);
            builder.append(sep);
        }
        //最后多余的分隔符要去掉
        return builder.substring(0, builder.length() - sep.length());
    }


    @Test
    public void test9() {
        String src = "Let's take LeetCode contest";
        String[] arrs = src.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String arr : arrs) {
            for (int i = arr.length() - 1; i >= 0; i--) {
                builder.append(arr.charAt(i));
            }
            builder.append(" ");
        }
        String target = builder.substring(0, builder.length() - 1);
        System.out.println(target);
    }


    @Test
    public void test10() {
        System.out.println(checkIp2("10.1.67.123"));
    }

    public boolean checkIp2(String ip) {
        String[] arrs = ip.split("\\.");//转译
        if (arrs.length != 4) {
            return false;
        }
        String reg = "\\d||[1-9]\\d{1,2}";
        for (String arr : arrs) {
            try {
                if (!arr.matches(reg) || Integer.parseInt(arr) > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;

    }

    public boolean checkIp(String ip) {
        String[] arrs = ip.split("\\.");//转译
        if (arrs.length != 4) {
            return false;
        }
        for (String arr : arrs) {
            try {
                Integer num = Integer.parseInt(arr);
                if (num > 255 || num < 0) {
                    return false;
                }
                if (!arr.equals("0") && arr.startsWith("0")) {//避免01 形式出现
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


}
