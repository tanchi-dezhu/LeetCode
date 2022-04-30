package leetcode.simple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_20
{
    public static boolean isValid(String s)
    {
        int n = s.length();
        if (n % 2 == 1)
        {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>()
        {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
//            如果包含右括号
            if (pairs.containsKey(ch))
            {
//                则判断栈是否为空或者栈里面的括号不是左括号则返回
                if (stack.isEmpty() || stack.peek() != pairs.get(ch))
                {
                    return false;
                }
//                如果右括号和栈里面的左括号对应则提出栈里面的数据
                stack.pop();
            } else
            {
//                如果不包含右括号则添加到栈里面
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("[{}](}"));
    }
}
