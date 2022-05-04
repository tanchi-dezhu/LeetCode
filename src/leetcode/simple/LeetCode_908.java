package leetcode.simple;

import java.util.Arrays;

public class LeetCode_908
{
    public static int smallestRangeI(int[] nums, int k)
    {
        Arrays.sort(nums);
        return Math.max(0, nums[nums.length - 1] - nums[0] - k * 2);
    }

    public static void main(String[] args)
    {
        int[] arrays = new int[]{1, 3, 6};
        System.out.println(smallestRangeI(arrays, 3));
    }
}
