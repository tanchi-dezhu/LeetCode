package leetcode.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_58
{
    public static int lengthOfLastWord(String s)
    {
        if (s.trim().equals(""))
        {
            return 0;
        }
        String[] splits = s.split(" ");
        List<String> collect = Arrays.stream(splits).filter(x -> !x.trim().equals("")).collect(Collectors.toList());
        return collect.get(collect.size() - 1).length();
    }

    public static void main(String[] args)
    {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
