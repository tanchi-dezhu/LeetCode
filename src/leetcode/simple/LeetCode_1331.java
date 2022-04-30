package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1331
{
//    public static int[] arrayRankTransform(int[] arr)
//    {
//
//        int[] temp = Arrays.stream(arr).sorted().distinct().toArray();
//
//        int[] result = new int[arr.length];
//        for (int j = 0; j < arr.length; j++)
//        {
//            for (int k = 0; k < temp.length; k++)
//            {
//                if (arr[j] == temp[k])
//                {
//                    result[j] = k + 1;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < result.length; i++)
//        {
//            System.out.println(result[i]);
//        }
//        return result;
//    }

    //桶排序
//    public static int[] arrayRankTransform(int[] arr)
//    {
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        for (int num : arr)
//        {
//            if (num < min) min = num;
//            if (num > max) max = num;
//        }
//
//        int[] count = new int[max - min + 1];
//        for (int num : arr)
//            count[num - min] = 1;
//
//        int[] preSum = new int[count.length + 1];
//        for (int i = 1; i < preSum.length; i++)
//            preSum[i] = preSum[i - 1] + count[i - 1];
//
//        int[] ans = new int[arr.length];
//        int index = 0;
//        for (int num : arr)
//            ans[index++] = preSum[num - min] + 1;
//
//        for (int i = 0; i < ans.length; i++)
//        {
//            System.out.println(ans[i]);
//        }
//        return ans;
//    }

    public static int[] arrayRankTransform(int[] arr)
    {
        int a[] = arr.clone();
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < a.length; i++)
        {
            if (i > 0 && a[i] != a[i - 1])
            {
                map.put(a[i], index);
                index++;
            }
            if (i == 0)
            {
                map.put(a[i], index);
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
    public static void main(String[] args)
    {
//        int[] arr = new int[]{40,10,20,30};
        int[] arr = new int[]{30, 30, 30};
//        int[] arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};

        arrayRankTransform(arr);
    }
}
