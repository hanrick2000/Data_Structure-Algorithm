package niuke;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);

        if (stack2.isEmpty() || node <= stack2.peek()){
            stack2.push(node);
        }
    }

    public void pop() {
        if (stack1.peek() == stack2.peek()){
            stack2.pop();
        }

        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
