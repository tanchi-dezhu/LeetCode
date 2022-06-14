package leetcode.simple;

import java.util.Comparator;
import java.util.Stack;

public class LeetCode_155
{
    class MinStack
    {
        public Stack<Integer> stack = new Stack();

        public MinStack()
        {

        }

        public void push(int val)
        {
            stack.push(val);
        }

        public void pop()
        {
            stack.pop();
        }

        public int top()
        {
            return stack.peek();
        }

        public int getMin()
        {
            return stack.stream().min(Comparator.comparing(Integer::intValue)).get();
        }
    }

    class MinStack1
    {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        public MinStack1()
        {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x)
        {
            stack.push(x);
            if (min_stack.isEmpty() || x <= min_stack.peek())
            {
                min_stack.push(x);
            }
        }

        public void pop()
        {
            if (stack.pop().equals(min_stack.peek()))
            {
                min_stack.pop();
            }
        }

        public int top()
        {
            return stack.peek();
        }

        public int getMin()
        {
            return min_stack.peek();
        }
    }

    public static void main(String[] args)
    {

    }
}
