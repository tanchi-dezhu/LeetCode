package leetcode.simple;

import util.ListNode;

public class LeetCode_83
{

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode1 = deleteDuplicates1(listNode);
    }
}
