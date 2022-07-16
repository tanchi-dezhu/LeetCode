package leetcode.medium;

import java.util.Arrays;

public class LeetCode_287
{
    public static int findDuplicate(int[] nums)
    {
        int[] ints = Arrays.stream(nums).sorted().toArray();

        int pre = 0;
        for (int anInt : ints)
        {

            if (anInt == pre)
            {
                return anInt;
            }
            pre = anInt;
        }
        return 0;
    }

    public static void main(String[] args)
    {

        int[] array = new int[]{1, 2, 2, 3, 4, 6};
        System.out.println(findDuplicate(array));

    }
}
