package leetcode.simple;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_762
{
    static boolean[] hash = new boolean[40];

    static
    {
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int x : nums) hash[x] = true;
    }

    public static int countPrimeSetBits1(int left, int right)
    {
        int ans = 0;
        for (int i = left; i <= right; i++)
        {
            int x = i;
            x = (x & 0x55555555) + ((x >>> 1) & 0x55555555);
            x = (x & 0x33333333) + ((x >>> 2) & 0x33333333);
            x = (x & 0x0f0f0f0f) + ((x >>> 4) & 0x0f0f0f0f);
            x = (x & 0x00ff00ff) + ((x >>> 8) & 0x00ff00ff);
            x = (x & 0x0000ffff) + ((x >>> 16) & 0x0000ffff);
            if (hash[x]) ans++;
        }
        return ans;
    }

    public static int countPrimeSetBits(int left, int right)
    {
        int result = 0;
        ArrayList<Integer> valueList = new ArrayList<>();
        for (; left <= right; left++)
        {
            int value = 0;
            String binaryString = Integer.toBinaryString(left);
            byte[] bytes = binaryString.getBytes(StandardCharsets.UTF_8);
            for (byte index : bytes)
            {
                if (index == 49)
                {
                    value++;
                }
            }
            valueList.add(value);
        }

        List<Integer> collect = valueList.stream().filter(x -> BigInteger.valueOf(x).isProbablePrime(100)).collect(Collectors.toList());
        return collect.size();
    }


    public static boolean check(int x)
    {
        int cnt = 0;
        while (x != 0)
        {
            x -= (x & -x);
            cnt++;
        }
        if (cnt < 2) return false;
        for (int i = 2; i <= cnt / i; i++)
        {
            if (cnt % i == 0) return false;
        }
        return true;
    }

    public static int countPrimeSetBits2(int left, int right)
    {
        int ans = 0;
        for (int i = left; i <= right; i++)
        {
            if (check(i)) ans++;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(countPrimeSetBits1(10, 15));
        System.out.println(countPrimeSetBits1(6, 10));

        boolean probablePrime = BigInteger.valueOf(11).isProbablePrime(100);
        System.out.println(probablePrime);
        ;

        boolean probablePrime1 = BigInteger.valueOf(12).isProbablePrime(100);
        System.out.println(probablePrime1);
    }
}
