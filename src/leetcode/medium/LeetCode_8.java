package leetcode.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode_8 {
//    创建正则表达式
//    1、+—不能同时出现
    final static Pattern pattern = Pattern.compile("[-+]?[0-9]+");
    public int myAtoi(String str) {
//        消除字符串前后的空格
        String strTrim = str.trim();
        Matcher matcher = pattern.matcher(strTrim);
//        检测是否符合表达式
        if (matcher.lookingAt()) {
//            符合就返回符合的子穿长度
            String strNum = strTrim.substring(0, matcher.end());
            // 如果直接转32位int出现NFE那么就只要判断是Integer的最大值还是最小值就好了
            try {
                return Integer.parseInt(strNum);
            } catch (NumberFormatException nfe) {
                return strNum.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        LeetCode_8 leetCode_seven = new LeetCode_8();
        int num = leetCode_seven.myAtoi("  +-2215 wr 165 ");
        System.out.println(num);
    }
}
