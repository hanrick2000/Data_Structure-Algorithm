package niuke;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder_1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
