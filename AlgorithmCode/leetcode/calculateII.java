package leetcode;

import java.util.Stack;

public class calculateII {
    public int calculate(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])){
                number = number*10 + (int)(c[i] - '0');
            }

            if (!Character.isDigit(c[i]) && c[i] != ' ' || i == c.length-1){
                if (sign == '+'){
                    stack.push(number);
                }if (sign == '-'){
                    stack.push(-number);
                }
                if (sign == '*'){
                    stack.push(stack.pop()*number);
                }
                if (sign == '/'){
                    stack.push(stack.pop()/number);
                }
                sign = c[i];
                number = 0;
            }
        }

        int res = 0;
        for (int i:stack) {
            res += i;
        }

        return res;
    }
}
