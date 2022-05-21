package leetcode.simple;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_961
{
    public static int repeatedNTimes(int[] nums)
    {

        int number = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxNum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                int repeatCount = map.get(nums[i]) + 1;
                if (repeatCount > maxNum)
                {
                    maxNum = repeatCount;
                    number = nums[i];
                }
                map.put(nums[i], repeatCount);
            } else
            {
                map.put(nums[i], 1);
            }
        }
        return number;
    }

    public static void main(String[] args)
    {

        int[] nums = new int[]{3, 1, 3, 2};
        System.out.println(repeatedNTimes(nums));
    }
}
