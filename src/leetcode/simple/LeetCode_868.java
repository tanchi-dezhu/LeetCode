package leetcode.simple;

public class LeetCode_868
{
    public static int binaryGap(int n)
    {
        String binary = Integer.toBinaryString(n);

        int lastOneIdx = n, max = 0;
        for (int i = 0; i < binary.length(); i++)
        {
            if (binary.charAt(i) == '1')
            {
                max = Math.max(max, i - lastOneIdx);
                lastOneIdx = i;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {

        System.out.println(binaryGap(198));
    }
}
