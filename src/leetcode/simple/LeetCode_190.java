package leetcode.simple;

public class LeetCode_190
{
    public static int reverseBits(int n)
    {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i)
        {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args)
    {
        int reverseBits = reverseBits(43261596);
        System.out.println(reverseBits);
    }
}
