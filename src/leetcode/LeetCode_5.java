package leetcode;

public class LeetCode_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
//            获取回文子串是奇数的情况
            int len1 = count(s, i, i);
//            获取回文子串是偶数的子串长度
            int len2 = count(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int count(String s, int left, int right) {
        int L = left, R = right;
//        判断左右是否相同
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        LeetCode_5 leetCode_five=new LeetCode_5();
        System.out.println(leetCode_five.longestPalindrome("csdeedn"));
    }
}
