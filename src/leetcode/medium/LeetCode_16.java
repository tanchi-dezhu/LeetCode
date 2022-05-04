package leetcode.medium;

import java.util.Arrays;

/**
 * @author jun
 * @date 2021年05月24日 14:31
 */
public class LeetCode_16
{
    public static void main(String[] args)
    {
//        int[] nums = {1, 3, 4, -1, -3};
        int[] nums = {-3, -1, 1, 3, 4,};
        int sum = sumNumByTarget(nums, 10);
        System.out.println(sum);
    }

    public static int sumNumByTarget(int[] nums, int target)
    {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++)
        {
            int start = i + 1, end = nums.length - 1;
            while (start < end)
            {
                int sums = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sums) < Math.abs(target - ans))
                {
                    ans = sums;
                }
                if (sums > target)
                {
                    end--;
                } else if (sums < target)
                {
                    start++;
                } else return ans;
            }
        }
        return ans;
    }
}
