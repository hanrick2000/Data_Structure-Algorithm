package niuke;

public class FindKthToTail {
    public ListNode FindKthToTail_1(ListNode head,int k) {
        if (head == null || k <= 0){
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        while (k > 0 ){
            if (first == null){
                return null;
            }
            first = first.next;
            k--;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
