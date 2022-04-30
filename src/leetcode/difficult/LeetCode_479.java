package leetcode.difficult;

/***
 * 最大回文数乘积
 */
public class LeetCode_479
{
    public static int largestPalindrome(int n)
    {
        if (n == 1)
        {
            return 9;
        }

        int max = (int) Math.pow(10, n) - 1;
        int min = (int) Math.pow(10, n - 1);

        for (int i = max; i >= min; i--)
        {
            long rightPre = i, maxManacher = i;
            while (rightPre > 0)
            {
                maxManacher = maxManacher * 10 + rightPre % 10;
                rightPre = rightPre / 10;
            }

            for (long j = max; (j * j) >= maxManacher; --j)
            {
                if (maxManacher % j == 0)
                {
                    return (int) (maxManacher % 1337);
                }
            }

        }
        return 0;
    }

    public static int sLargestPalindrome(int n)
    {
        if (n == 1)
        {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left)
        { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10)
            {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x)
            {
                if (p % x == 0)
                { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(largestPalindrome(5));
        System.out.println(sLargestPalindrome(5));
    }
}
