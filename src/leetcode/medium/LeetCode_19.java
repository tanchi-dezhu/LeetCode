package leetcode.medium;

import leetcode.medium.LeetCode_2;

public class LeetCode_19
{
    public LeetCode_2.ListNode removeNthFromEnd(LeetCode_2.ListNode head, int n)
    {//快慢指针
        LeetCode_2.ListNode fast = head;//快指针
        LeetCode_2.ListNode slow = head;//慢指针
        int sz = 1;
        int count = n;
        while (fast.next != null)
        {
            fast = fast.next;
            sz++;
            if (count <= 0) slow = slow.next;
            count--;
        }
//        执行玩while循环之后，slow在倒数的n+1的位置上
        if (n == sz) return head.next;
        else if (n == 1)
        {
            slow.next = null;
            return head;
        }
//        所以需要将slow移到下一个节点
        slow.next = slow.next.next;
        return head;
    }
}
