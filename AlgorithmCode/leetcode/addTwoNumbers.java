package leetcode;

import java.util.Stack;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode(0);
        while (!stack1.empty() || !stack2.empty()){
            int m = stack1.empty()?0:stack1.pop();
            int n = stack2.empty()?0:stack2.pop();

            sum = m + n + carry;
            carry = sum/10;
            sum = sum % 10;

            res.val = sum;
            ListNode prv = res;
            res = new ListNode(0);
            res.next = prv;
        }

        if (carry > 0){
            res.val = carry;
            return res;
        }
        return res.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
