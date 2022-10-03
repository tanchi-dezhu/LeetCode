package leetcode.simple;

import java.util.HashMap;

public class LeetCode_1
{
    public int[] twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] twoSum1(int[] nums, int target)
    {
        HashMap<Integer, Integer> habitable = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int subValue = target - nums[i];
            if (habitable.containsKey(subValue))
            {
                return new int[]{i, habitable.get(subValue)};
            }
            habitable.put(nums[i], i);
        }

        return null;
    }

    public static void main(String args[])
    {
        LeetCode_1 leetCode_one = new LeetCode_1();
        int[] num = new int[]{15, 28, 36, 24, 34, 25};
        int[] end = leetCode_one.twoSum1(num, 49);
        for (int i = 0; i < end.length; i++)
        {
            System.out.println(end[i]);
        }
    }
}
