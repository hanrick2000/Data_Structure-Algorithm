package niuke;

public class Merge {
    public ListNode Merge_1(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (list1 != null || list2 != null){
            if (list1 == null){
                res.next = list2;
                break;
            }
            if (list2 == null){
                res.next = list1;
                break;
            }

            if (list1.val >= list2.val){
                res.next = list2;
                list2 = list2.next;
            }else {
                res.next = list1;
                list1 = list1.next;
            }

            res = res.next;
        }

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
