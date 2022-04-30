package leetcode.medium;

public class LeetCode_2 {
    public static class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int x){
            val=x;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
//            判断是否等于null
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    public static void main(String args[]){
        LeetCode_2 leetCode_two=new LeetCode_2();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(4);
        System.out.println(leetCode_two.addTwoNumbers(l1,l2).val);
    }
}
