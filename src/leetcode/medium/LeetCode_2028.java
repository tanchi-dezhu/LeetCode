package leetcode.medium;

import java.util.Arrays;

public class LeetCode_2028
{
    public static int[] missingRolls(int[] rolls, int mean, int n)
    {
        int preSum = Arrays.stream(rolls).sum();
        int suffixMaxSum = n * 6;
        int sum = mean * (rolls.length + n);
        if ((preSum + suffixMaxSum) < sum || (preSum + n * 1) > sum)
        {
            return new int[]{};
        }

        int suffixSum = sum - preSum;
        if (suffixSum < 0)
        {
            return new int[]{};
        }

        int[] newArrays = new int[n];

        int suffixAgv = suffixSum / n;
        for (int i = 0; i < n; i++)
        {
            newArrays[i] = suffixAgv;
        }
        int remainIndex = suffixSum % (suffixAgv * newArrays.length);
        recursion(newArrays, n, remainIndex);
        return newArrays;
    }

    public static void recursion(int[] arrys, int n, int remainIndex)
    {
        if (remainIndex < n)
        {
            for (int i = 0; i < remainIndex; i++)
            {
                arrys[i] += 1;
            }
        } else
        {
            for (int i = 0; i < n; i++)
            {
                arrys[i] += 1;
            }
            recursion(arrys, n, remainIndex);
        }
    }

    public static void main(String[] args)
    {
        int[] arrys = new int[]{4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4, 5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3};
        int[] ints = missingRolls(arrys, 2, 53);
        for (int saccharin : ints)
        {
            System.out.println(saccharin);
        }
    }
}
