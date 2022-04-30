package leetcode.simple;

public class LeetCode_53
{
    public static int maxSubArray(int[] nums)
    {
        int result = nums[0];
        int sum = 0;
        for (int num : nums)
        {
            if (sum > 0)
            {
                sum += num;
            }else
            {
                sum = num;
            }
            result = Math.max(sum,result);
        }

        return result;
    }

    /***
     * 贪心算法求最大连续数组和
     * @param nums
     * @return
     */
    public static int greedMaxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(array));

        System.out.println(greedMaxSubArray(array));
    }

}
