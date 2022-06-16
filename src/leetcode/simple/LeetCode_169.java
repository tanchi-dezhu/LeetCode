package leetcode.simple;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_169
{
    public static int majorityElement(int[] nums)
    {

        Map<Integer, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::intValue));

        int result = 0;
        int temp = 0;
        for (List<Integer> value : collect.values())
        {
            if (temp < value.size())
            {
                temp = value.size();
                result = value.get(0);
            }

        }
        return result;
    }


    public static int majorityElement1(int[] nums)
    {

        Map<Integer, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::intValue));

        Map.Entry<Integer, List<Integer>> majorityEntry = null;
        for (Map.Entry<Integer, List<Integer>> entry : collect.entrySet())
        {
            if (majorityEntry == null || entry.getValue().size() > majorityEntry.getValue().size())
            {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    public static int majorityElement2(int[] nums)
    {
        Arrays.sort(nums);
        int index = nums.length >> 1;
        return nums[index];
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement2(array));


        System.out.println(100 >> 1);//50
        System.out.println(20 >> 1);//10
        System.out.println(9 >> 1);//4
        System.out.println(4 >> 1);//2
        System.out.println(3 >> 1);//1

        long a = 101;
        System.out.println(a>>1);
    }
}
