package leetcode.medium;

public class LeetCode_307
{

    private int[] sum; // sum[i] 表示第 i 个块的元素和
    private int size; // 块的大小
    private int[] nums;

    public LeetCode_307(int[] nums)
    {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        sum = new int[(n + size - 1) / size]; // n/size 向上取整
        for (int i = 0; i < n; i++)
        {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val)
    {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right)
    {
        int b1 = left / size, i1 = left % size, b2 = right / size, i2 = right % size;
        if (b1 == b2)
        { // 区间 [left, right] 在同一块中
            int sum = 0;
            for (int j = i1; j <= i2; j++)
            {
                sum += nums[b1 * size + j];
            }
            return sum;
        }
        int sum1 = 0;
        for (int j = i1; j < size; j++)
        {
            sum1 += nums[b1 * size + j];
        }
        int sum2 = 0;
        for (int j = 0; j <= i2; j++)
        {
            sum2 += nums[b2 * size + j];
        }
        int sum3 = 0;
        for (int j = b1 + 1; j < b2; j++)
        {
            sum3 += sum[j];
        }
        return sum1 + sum2 + sum3;
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1, 3, 4, 5, 2, 9};
        LeetCode_307 leetCode_307 = new LeetCode_307(array);
        System.out.println(leetCode_307.sumRange(0, 4));
        leetCode_307.update(3, 10);
        System.out.println(leetCode_307.sumRange(0, 4));
    }
}
