package leetcode.simple;

public class LeetCode_258
{
    public static int addDigits(int num)
    {
        int result = 0;
        while (num % 10 > 0 || num > 9)
        {
            int digit = num % 10;
            num = num / 10;
            result += digit;
            if (num == 0 && result >= 10)
            {
                num = result;
                result = 0;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(addDigits(10));
    }
}
