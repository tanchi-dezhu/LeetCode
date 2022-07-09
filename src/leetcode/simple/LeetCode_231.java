package leetcode.simple;

public class LeetCode_231
{
    public static boolean isPowerOfTwo(int n)
    {
        int pre = 0;

        while (n >= 1)
        {
            if ((n & 1) == 1)
            {
                pre += 1;
            }
            n = n >> 1;
        }

        return pre == 1 ? true : false;
    }

    /***
     * 因为要是2的幂次方，所有二进制位只能有一个1，将原数值-1之后，做&运算肯定就等于0
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo1(int n)
    {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(isPowerOfTwo(4));

        System.out.println(Integer.toBinaryString(10));
    }
}
