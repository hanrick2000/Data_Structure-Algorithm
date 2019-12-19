package leetcode;

import java.util.Stack;

public class isValid {
    public boolean isValid_1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (char a:c){
            if (a == '('){
                stack.push(')');
            }else if (a == '{'){
                stack.push('}');
            }else if (a == '['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != a){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
