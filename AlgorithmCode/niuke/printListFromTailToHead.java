package niuke;

import java.util.ArrayList;
import java.util.Stack;

public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        // 非递归，使用栈
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode){
        // 递归

        ListNode p = listNode;
        if (p != null){
            if (p.next != null){
                printListFromTailToHead_2(p.next);
            }
            res.add(p.val);
        }

        return res;
    }

    public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode){
        // 头插法
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null){
            result.add(0,listNode.val);
            listNode = listNode.next;
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
