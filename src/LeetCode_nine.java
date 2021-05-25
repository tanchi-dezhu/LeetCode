public class LeetCode_Nine {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int help = 1;
        int tmp = x;
//        算出x的是几位数的整数
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
//            判断第一个数字与最后一个数字是不是相同
            if (x % 10 != x / help) {
                return false;
            }
//            去掉首位和末尾
            x = x % help / 10;
//            倍数缩小100杯
//            末尾和首位 个10倍
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_Nine leetCode_nine=new LeetCode_Nine();
        System.out.println(leetCode_nine.isPalindrome(1231));
    }
}
