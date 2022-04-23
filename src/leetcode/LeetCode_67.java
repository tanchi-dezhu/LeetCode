package leetcode;

public class LeetCode_67
{
    public static String addIntegerBinary(String a, String b)
    {
        int aInteger = Integer.parseInt(a, 2);
        int bInteger = Integer.parseInt(b, 2);

        int sum = aInteger + bInteger;

        return Integer.toBinaryString(sum);
    }

    public static String addBinary(String a, String b)
    {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i)
        {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0)
        {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


    public static void main(String[] args)
    {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }
}
