package leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_30
{
    public static List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0 || words == null) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();           //单个word长度
        int word_num = words.length;              //word的个数
        int all_len = one_word * word_num;          //子串长度
        String reduce = Arrays.stream(words).reduce("", String::concat);
        System.out.println(reduce);
        for (String word : words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);     //存储单词words: key为单词，value为单词出现次数
        }
        for (int i = 0; i < s.length() - all_len + 1; i++)
        {      //截取所有单词串联的字符串
            String tmp = s.substring(i, i + all_len);             //substring（x, y）:x, y分别为开始/结束位置，左闭右开，[ )
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word)
            {        //所有单词串联的字符串，按照单个word长度拆分
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);     //截取字符串出现次数，key为单词，value为单词出现次数
            }
            if (map.equals(tmp_map))
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        String[] strings = {"foos", "bar"};
        List<Integer> list = findSubstring("barfoosthefoobarman", strings);
        for (Integer integer : list)
        {
            System.out.println(integer);
        }
    }
}
