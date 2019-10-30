package leetcode;

import java.util.Stack;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        if (head.next == null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode res = head;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            if (res.val != stack.peek()){
                return false;
            }
        }
        return true;

    }
}
