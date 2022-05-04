package leetcode.simple;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_804
{
    public static HashMap<String, String> arraysMap = new HashMap();
    public static String[] arrays = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--."
            , "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-"
            , ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    static
    {
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++)
        {
            arraysMap.put(String.valueOf(c), arrays[index]);
            index++;
        }
    }

    public static int uniqueMorseRepresentations(String[] words)
    {
        HashSet<String> hashSet = new HashSet<>();
        for (String word : words)
        {
            char[] charArray = word.toCharArray();
            String mose = "";
            for (char c : charArray)
            {
                mose += arraysMap.get(String.valueOf(c));
            }
            hashSet.add(mose);
        }

        return hashSet.size();
    }

    public static void main(String[] args)
    {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));

    }
}
