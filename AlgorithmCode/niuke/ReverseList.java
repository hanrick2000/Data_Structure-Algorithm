package niuke;

public class ReverseList {
    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = ReverseList_1(next);
        next.next = head;
        head.next = null;
        return newHead;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
