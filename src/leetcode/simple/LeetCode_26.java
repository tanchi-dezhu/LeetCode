package leetcode.simple;

public class LeetCode_26
{
    public static int removeDuplicates(int[] nums)
    {
        if (nums.length <= 1)
        {
            return nums.length;
        }

        int index = 0;
        for (int num : nums)
        {
            if (nums[index] == num)
            {
                nums[index] = num;
            } else
            {
                index++;
                nums[index] = num;
            }
        }
        return index + 1;
    }

    public static void main(String[] args)
    {
        int[] arrys = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(arrys));
    }
}
