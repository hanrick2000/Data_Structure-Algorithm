package leetcode;

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode remA = headA;
        ListNode remB = headB;
        while (remA != remB){
            remA = remA == null?headB:remA.next;
            remB = remB == null?headA:remB.next;
        }

        return remA;
    }
}
