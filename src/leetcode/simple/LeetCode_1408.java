package leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1408
{
    public static List<String> stringMatching(String[] words)
    {
        List<String> resultList = new ArrayList<>();
        for (String word : words)
        {
            String subString = Arrays.stream(words)
                    .filter(x -> x.contains(word) && !x.equals(word))
                    .findFirst().orElse(null);
            if (subString!= null)
            {
                resultList.add(word);
            }
        }

        return resultList;
    }

    public static void main(String[] args)
    {
        String[] params = new String[]{"mass", "as", "hero", "superhero"};
        stringMatching(params).forEach(x ->
        {
            System.out.println(x);
        });
    }
}
