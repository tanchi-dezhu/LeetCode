package leetcode.difficult;

public class LeetCode_4
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int i = 0, j = 0, k = 0;
//        创建一个新的数组,把两个数组由小到大进行排列
        int[] shu = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length)
        {
            if (nums1[i] < nums2[j])
            {
                shu[k++] = nums1[i++];
            } else
            {
                shu[k++] = nums2[j++];
            }
        }
        while (i < nums1.length)
        {
            shu[k++] = nums1[i++];
        }
        while (j < nums2.length)
        {
            shu[k++] = nums2[j++];
        }
//      判断数组是偶数还是奇数
        int num = shu.length % 2;
        if (num == 0)
        {
            Double d = Double.valueOf(shu.length / 2);
            int d1 = d.intValue();
            if (d1 != 0)
            {
                Double n = Double.valueOf((shu[d1] + shu[d1 - 1])) / 2;
                return n;
            }
        } else
        {
            Double d = Double.valueOf(shu.length) / 2;
            d = d - 0.5;
            return shu[d.intValue()];
        }
        return 0;
    }

    public static void main(String[] args)
    {
        LeetCode_4 leetCode_four = new LeetCode_4();
        int[] a = new int[]{2, 3, 4};
        int[] b = new int[]{4, 6, 5};
        System.out.println(leetCode_four.findMedianSortedArrays(a, b));
    }
}
