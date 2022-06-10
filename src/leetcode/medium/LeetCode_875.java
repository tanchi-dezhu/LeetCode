package leetcode.medium;

import java.util.Arrays;

public class LeetCode_875
{

    public static int minEatingSpeed(int[] piles, int h)
    {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right)
        {

            int mid = left + (right - left) / 2;

            int time = calculateSum(piles, mid);
            if (time > h)
            {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else
            {
                right = mid;
            }
        }

        return left;
    }

    private static int calculateSum(int[] piles, int speed)
    {
        int sum = 0;
        for (int pile : piles)
        {
            // 求余
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{2, 3, 5, 7, 10};
        System.out.println(minEatingSpeed(array, 6));
    }
}
