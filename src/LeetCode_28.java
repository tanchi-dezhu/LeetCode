import java.util.ArrayList;
import java.util.List;

public class LeetCode_28
{
    public static int strStr(String haystack, String needle)
    {
        if ("".equals(needle))
        {
            return 0;
        }
//        获取包含的所有下标集合
        List<Integer> index = getIndex(haystack, needle.substring(0, 1));
        for (Integer integer : index)
        {
//            如果最后字符串超过则直接返回-1
            if (integer + needle.length() > haystack.length())
            {
                return -1;
            }
            String substring = haystack.substring(integer, integer + needle.length());
            if (substring.equals(needle))
            {
                return integer;
            }
        }
        return -1;
    }

    /**
     * 获取strings字符串中所有str字符所在的下标
     *
     * @param strings 母字符串
     * @param str     子字符串
     * @return 字符串在母字符串中下标集合，如果母字符串中不包含子字符串，集合长度为零
     */
    public static List<Integer> getIndex(String strings, String str)
    {
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        while (strings.indexOf(str) != -1)
        {
            //截取包含自身在内的前边部分
            String aa = strings.substring(0, strings.indexOf(str) + str.length());
            flag = flag + aa.length();
            list.add(flag - str.length());
            strings = strings.substring(strings.indexOf(str) + str.length());
        }
        return list;
    }

    public static void main(String[] args)
    {
        System.out.println(strStr("", ""));
    }
}

