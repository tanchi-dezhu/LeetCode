package leetcode.simple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode_136
{
    public static int singleNumber(int[] nums)
    {
        Map<Integer, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::intValue));

        int resultInt = 0;

        int temp = Integer.MAX_VALUE;
        for (List<Integer> value : collect.values())
        {
            if (value.size() < temp)
            {
                temp = value.size();
                resultInt = value.get(0);
            }

        }
        return resultInt;
    }


    /**
     * 只限定其他数字只出现两次的话，可以使用异或运算
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=a⊕a⊕b=0⊕b=b
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums)
    {
        int single = 0;
        for (int num : nums)
        {
            single ^= num;
        }
        return single;
    }


    public static void main(String[] args)
    {
        int[] array = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(array));

    }
}
