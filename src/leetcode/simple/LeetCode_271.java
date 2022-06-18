package leetcode.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class LeetCode_271
{
    public static boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums)
        {
            if (!set.add(x))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(array));
    }
}
