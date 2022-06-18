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

    /**
     * 能够被9整除的整数，各位上的数字加起来也必然能被9整除，所以，连续累加起来，最终必然就是9。
     * 不能被9整除的整数，各位上的数字加起来，结果对9取模，和初始数对9取摸，是一样的，所以，连续累加起来，最终必然就是初始数对9取摸。
     *
     * @param num
     * @return
     */
    public static int addDigits1(int num)
    {
        if (num == 0)
        {
            return 0;
        }
        if (0 == num % 9)
        {
            return 9;
        }
        return num % 9;
//        return (num-1) % 9 + 1;
    }

    public static void main(String[] args)
    {
        System.out.println(addDigits1(100));
    }
}
