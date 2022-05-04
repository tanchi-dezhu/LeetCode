package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
//        遍历String
        for (int end = 0, start = 0; end < n; end++)
        {
            char alpha = s.charAt(end);
//            判断该数字是否重复
            if (map.containsKey(alpha))
            {
//                如果重复取出开始到重复字母的子串长度
                start = Math.max(map.get(alpha), start);
            }
//            和之前的子串长度进行对比,获得最长的子串
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        LeetCode_3 leetCode_three = new LeetCode_3();
        System.out.println(leetCode_three.lengthOfLongestSubstring("dengbasg"));
    }
}
