package leetcode.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_35
{
    public static int searchInsert(int[] nums, int targets)
    {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        List<Integer> collect = list.stream().filter(x -> x < targets).collect(Collectors.toList());
        return collect.size();
    }

    public static void main(String[] args)
    {
        int[] ints ={1,3,5,7};
        int i = searchInsert(ints, 9);
        System.out.println(i);
    }
}
