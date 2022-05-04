package leetcode.medium;

public class LeetCode_11
{
    public int maxArea(int[] height)
    {
        int length = height.length;
        int[][] intArray = new int[length + 1][1];
//        把所有坐标存储在二维数组里面
        for (int i = 1; i < length + 1; i++)
        {
            intArray[i][0] = height[i - 1];
        }
        int index = 0;
//        暴力破解一个个进行比对 取出最大的
        for (int i = 1; i < length + 1; i++)
        {
            for (int a = i + 1; a < length + 1; a++)
            {
                if (intArray[i][0] < intArray[a][0])
                {
                    int high = intArray[i][0];
                    int weight = a - i;
                    int s = high * weight;
                    if (s > index)
                    {
                        index = s;
                    }
                } else
                {
                    int high = intArray[a][0];
                    int weight = a - i;
                    int s = high * weight;
                    if (s > index)
                    {
                        index = s;
                    }
                }
            }
        }
        return index;
    }

    public static void main(String[] args)
    {
        LeetCode_11 LeetCode_Eleven = new LeetCode_11();
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(LeetCode_Eleven.maxArea(a));
    }
}
