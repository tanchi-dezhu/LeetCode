package leetcode.all;

import util.ListNode;

public class LeetCode_addTwoNumbers
{

	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null)
		{
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null)
			{
				head = tail = new ListNode(sum % 10);
			}
			else
			{
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null)
			{
				l1 = l1.next;
			}
			if (l2 != null)
			{
				l2 = l2.next;
			}
		}
		if (carry > 0)
		{
			tail.next = new ListNode(carry);
		}
		return head;
	}


	public static void main(String[] args)
	{
		int[] l1Arr = {2, 4, 3};
		int[] l2Arr = {5, 6, 4};

		ListNode l1 = new ListNode(l1Arr[0], new ListNode(l1Arr[1], new ListNode(l1Arr[2])));
		ListNode l2 = new ListNode(l2Arr[0], new ListNode(l2Arr[1], new ListNode(l2Arr[2])));

		LeetCode_addTwoNumbers a = new LeetCode_addTwoNumbers();

		ListNode listNode = a.addTwoNumbers(l1, l2);
		System.out.println();

	}
}
