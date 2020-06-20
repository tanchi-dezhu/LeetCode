import java.util.HashMap;

public class LeetCode_twelve {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
//        把对应的匹配值放到map里面
        HashMap hashMap = new HashMap();
        hashMap.put(1, "I");
        hashMap.put(5, "V");
        hashMap.put(10, "X");
        hashMap.put(50, "L");
        hashMap.put(100, "C");
        hashMap.put(500, "D");
        hashMap.put(1000, "M");

        int b = 1;
        int num1 = num;
//        循环取出最大的倍数是多少
        while (num1 > 10) {
            num1 = num1 / 10;
            b = b * 10;
        }
        String s = "";
        while (b > 0) {
//            取出第一个的数字值
            int c = num / b;
//            去掉第一个数字
            num = num % b;
//            获取这个倍数的一半
            int number = b * 10 / 2;
            if (b == 1000) {
                for (int i = 0; i < c; i++) {
                    s = s + (String) hashMap.get(b);
                }
            } else {
                if (hashMap.containsKey(c * b)) {
                    s = s + (String) hashMap.get(c * b);
                } else if (c == 4) {
                    s = s + (String) hashMap.get(b) + (String) hashMap.get((c + 1) * b);
                } else if (c == 9) {
                    s = s + (String) hashMap.get(b) + (String) hashMap.get(b * 10);
                } else if (c < 4) {
                    for (int i = 0; i < c; i++) {
                        s = s + (String) hashMap.get(b);
                    }
                } else if (c > 5) {
                    s = s + (String) hashMap.get(number);
                    for (int i = 0; i < c - 5; i++) {
                        s = s + (String) hashMap.get(b);
                    }
                }
            }
            b = b / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode_twelve leetCode_twelve = new LeetCode_twelve();
        System.out.println(leetCode_twelve.intToRoman(588));
    }
}
