package leetcode;

public class LeetCode_69
{
    public static int mySqrt(int x)
    {
        //算数平方根
        Double sqrt = Math.sqrt(x);
        return sqrt.intValue();
    }

    public static void main(String[] args)
    {
        System.out.println(mySqrt(8));
    }
}
