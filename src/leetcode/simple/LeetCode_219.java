package leetcode.simple;

/***
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-ii
 */

import java.util.HashMap;
import java.util.Map;

public class LeetCode_219
{
    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++)
        {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k)
            {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(array, 2));
    }
}
