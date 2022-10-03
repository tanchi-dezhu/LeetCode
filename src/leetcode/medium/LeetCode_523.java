package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_523
{
    public static boolean checkSubarraySum(int[] nums, int k)
    {
        int sum[] = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            sum[i] = sum[i - 1] + nums[i];
        }

        Set<Integer> modSet = new HashSet<>(nums.length);
        for (int i = nums.length - 1; i > 0; i--)
        {
            int mod = sum[i] % k;
            modSet.add(mod);

            int preMod = (sum[i - 1] - nums[i - 1]) % k;

            if (modSet.contains(preMod))
            {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums, 25));
    }
}
