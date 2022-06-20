package leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 */
public class LeetCode_228
{
    public static List<String> summaryRanges(int[] nums)
    {
        List<String> reusltList = new ArrayList<>();
        String index = "";
        boolean flag = true;
        for (int i = 0; i < nums.length; i++)
        {
            if (i != nums.length - 1)
            {
                if (flag && nums[i] + 1 == nums[i + 1])
                {
                    flag = false;
                    index += nums[i];
                } else if (!index.equals("") && nums[i] + 1 != nums[i + 1])
                {
                    flag = true;
                    index += "->" + nums[i];
                    reusltList.add(index);
                    index = "";
                } else if (index.equals(""))
                {
                    reusltList.add(String.valueOf(nums[i]));
                }
            } else if (!index.equals(""))
            {
                index += "->" + nums[i];
                reusltList.add(index);
            } else
            {
                reusltList.add(String.valueOf(nums[i]));
            }
        }
        return reusltList;
    }

    public static List<String> summaryRanges1(int[] nums)
    {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n)
        {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1)
            {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high)
            {
                temp.append("->");
                temp.append(String.valueOf(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{0, 2, 3, 4, 6, 8, 9};
        summaryRanges1(array).forEach(x -> System.out.println(x));
    }
}
