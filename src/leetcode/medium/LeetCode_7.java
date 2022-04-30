package leetcode.medium;

public class LeetCode_7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
//            判断数字是否是32位，如果超过32位就直接返回
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
//            把每次最后一个数拿出来变大十倍,再加上最后一个数
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
    public static void main(String args[]){
        LeetCode_7 leetCode_six = new LeetCode_7();
        int number=leetCode_six.reverse(1534236469);
        int b=3/10;
        System.out.println(number);
        System.out.println(b);
    }
}
