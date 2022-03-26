package leetcode;

public class LeetCode_70
{
    public static int climbStairs(int n)
    {
        if (n <= 3)
        {
            return n;
        }

        int[] dp = new int[]{1, 2};

        for (int i = 3; i <= n; i++)
        {
            int temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp + dp[0];
        }

        return dp[1];
    }

    public static void main(String[] args)
    {
        System.out.println(climbStairs(5));
    }
}
