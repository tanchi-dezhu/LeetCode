public class LeetCode_Fourteen {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs == null) return "";
        String s1 = "";
        String start = strs[0];
        for (int i = 1; i < strs.length; i++) {
            start = compare(start, strs[i]);
            if (start.length() == 0) {
                break;
            }
        }
        return start;
    }

    public static String compare(String s1, String s2) {
//        获取字符长度最小的值
        int end = Math.min(s1.length(), s2.length());
        int index = 0;
//        遍历是否有相同的元素
        for (int i = 0; i < end; i++) {
            if (s1.charAt(i) == s2.charAt(i) && index < end) {
                index++;
            } else {
                break;
            }
        }
        return s1.substring(0, index);
    }

    public static void main(String[] args) {
        LeetCode_Fourteen leetCode_fourteen = new LeetCode_Fourteen();
        String[] strings = new String[]{"aca", "cba"};
        System.out.println(leetCode_fourteen.longestCommonPrefix(strings));
    }
}
