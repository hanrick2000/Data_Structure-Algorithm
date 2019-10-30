package leetcode;

import java.util.HashMap;

public class hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        HashMap<ListNode,Integer> hashMap = new HashMap();
        while (head != null){
            if (!hashMap.containsKey(head)){
                hashMap.put(head,1);
            }else {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
