import java.util.HashMap;

public class LeetCode_Thirteen {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
//        存放键值
        HashMap hashMap = new HashMap();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        HashMap hashMap1 = new HashMap();
        hashMap1.put("IV", 4);
        hashMap1.put("IX", 9);
        hashMap1.put("XL", 40);
        hashMap1.put("XC", 90);
        hashMap1.put("CD", 400);
        hashMap1.put("CM", 900);
        int end = s.length();
        int num = 0;
        for (int i = 0; i < end; i++) {
            String key = String.valueOf(s.charAt(i));
            Boolean b=hashMap.containsKey(key);
//            判断是否符合
            if (i + 1 < end && hashMap1.containsKey(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)))) {
                    num += (int) hashMap1.get(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
                    i++;
            } else if (b) {
                String s1 = String.valueOf(key);
                num += (int) hashMap.get(s1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode_Thirteen leetCode_thirteen = new LeetCode_Thirteen();
        System.out.println(leetCode_thirteen.romanToInt("III"));
    }
}
