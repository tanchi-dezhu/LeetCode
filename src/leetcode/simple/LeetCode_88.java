package leetcode.simple;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class LeetCode_88
{
    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        for (int index = m; index < nums1.length; index++)
        {
            nums1[index] = nums2[index - m];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};

        merge(nums1, 3, nums2, 3);

    }
}
