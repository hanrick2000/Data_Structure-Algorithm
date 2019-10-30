package leetcode;

import java.util.Stack;

public class calculate {
    public int calculate_1(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int res = 0;
        int sign = 1;
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])){
                number = 10*number + (int)(c[i] - '0');
            }else if (c[i] == '+'){
                res += sign *number;
                number = 0;
                sign = 1;
            }else if (c[i] == '-'){
                res += sign *number;
                number = 0;
                sign = -1;
            }else if (c[i] == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }else if (c[i] == ')'){
                res += sign*number;
                number = 0;
                res = stack.pop()*res + stack.pop();
            }
        }

        if (number != 0){
            res += sign*number;
        }
        return res;
    }
}
