package leetcode.simple;

import java.util.LinkedList;

public class LeetCode_232
{
    LinkedList<Integer> queue = new LinkedList<Integer>();

    public void push(int x)
    {
        queue.add(x);
    }

    public int pop()
    {
        return queue.poll();
    }

    public int peek()
    {
        return queue.peek();
    }

    public boolean empty()
    {

        return queue.isEmpty();
    }

    public static void main(String[] args)
    {

    }
}
