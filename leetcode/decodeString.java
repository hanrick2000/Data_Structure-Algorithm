package leetcode;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> res = new Stack<>();

        res.push("");
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9'){
                int start = i;
                while (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') i++;

                int num = Integer.parseInt(s.substring(start,i+1));
                stack.push(num);
            }else if (c == '['){
                res.push("");
            }else if (c == ']'){
                String str = res.pop();
                StringBuilder sb = new StringBuilder();
                int times = stack.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                res.push(res.pop()+sb.toString());
            }else {
                res.push(res.pop() + c);
            }
            i++;
        }

        return res.pop();
    }
}
