package leetcode.medium;

import java.util.HashMap;

public class LeetCode_3
{
    public int lengthOfLongestSubstring(String s)
    {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int result = 0;

        int start = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char index = s.charAt(i);
            Integer preIndex = hashMap.get(index);
            if (preIndex != null)
            {
                start = Math.max(start, preIndex);
            }
            result = Math.max(result, i - start + 1);
            hashMap.put(index, i + 1);
        }

        return result;
    }


//    public int lengthOfLongestSubstring1(String s)
//    {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
////        遍历String
//        for (int end = 0, start = 0; end < n; end++)
//        {
//            char alpha = s.charAt(end);
////            判断该数字是否重复
//            if (map.containsKey(alpha))
//            {
////                如果重复取出开始到重复字母的子串长度
//                start = Math.max(map.get(alpha), start);
//            }
////            和之前的子串长度进行对比,获得最长的子串
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end + 1);
//        }
//        return ans;
//    }

    public static void main(String[] args)
    {
        LeetCode_3 leetCode_three = new LeetCode_3();
        System.out.println(leetCode_three.lengthOfLongestSubstring("abcabcbb"));
    }
}
