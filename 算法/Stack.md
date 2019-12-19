# Stack

## 计算器算法题

LeetCode 224. Basic Calculator

字符串中包含括号，+ - 没有空格和负数

```java
Input: "1 + 1"
Output: 2
Input: "1 + 1"
Output: 2
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
```

res：输出结果 number：保存加数值 sign 保存这次的运算符

对2-1+(4+5)举例：'2' -> num = 2; '-' -> res = 2, sigin = -1; '+' -> res = 2+ (-)*1:把前面一项结果计算出来；遇到括号，先保存res和sign值到栈，再计算括号内的值。最后从栈取出与括号内的值相加

```java
public int calculate(String s) {
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
```
LeetCode 227 Basic Calculator II

实现计算器，包含非负数，+ - * / 和空格，没有括号

```java
Input: "3+2*2"
Output: 7
Input: " 3/2 "
Output: 1
Input: " 3+5 / 2 "
Output: 5
```

首先保存sign符号，当number指向下一个值，如果sign为* 或/ ，从栈中取出前一个数字与number做运算然后压入栈中。否则放入栈中(‘-’号要把number取负号)，求最终结果的时候，从栈中取出所有数字相加

```java
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
```

LeetCode 772 Basic Calculator III

字符串表达式包含非负数，+ - * / 括号 空格

```java
"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
```

```java
public int calculate(String s) {
        s = s.replaceAll(" ", "");
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0, pre = 0, i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //consecutive digits as a number, save in `pre`
            if (Character.isDigit(ch)) {
                pre = pre*10+(ch-'0');
            }
            //recursively calculate results in parentheses
            if (ch == '(') {
                int j = findClosing(s.substring(i));
                pre = calculate(s.substring(i+1, i+j));
                i += j;
            }
            //for new signs, calculate with existing number/sign, then update number/sign
            if (i == s.length()-1 || !Character.isDigit(ch)) {
                switch (sign) {
                    case '+':
                        stack.push(pre); break;
                    case '-':
                        stack.push(-pre); break;
                    case '*':
                        stack.push(stack.pop()*pre); break;
                    case '/':
                        stack.push(stack.pop()/pre); break;
                }
                pre = 0;
                sign = ch;
            } 
            i++;
        }
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
    
    //Eliminate all "()" pairs, calculate the result in between and save in `pre`
    private int findClosing(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') level++;
            else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) break;
            } else continue;
        }
        return i;
    }
```

LeetCode 770 Basic Calculator IV



## 字符串编码解码

**LeetCode 394 Decode String**

给出字符串编码形式，求解码。保证字符串有效

```java
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

用两个Stack，其中一个保存数字，另一个保存字符串结果

```java
	public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> res = new Stack<>();

        res.push("");
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
			//保存数字
            if (c >= '0' && c <= '9'){
                int start = i;
                while (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') i++;

                int num = Integer.parseInt(s.substring(start,i+1));
                stack.push(num);
            }else if (c == '['){
                res.push("");
            // 对‘]’之前的string 和 num做处理，并且将结果与res拼接。
            }else if (c == ']'){
                String str = res.pop();
                StringBuilder sb = new StringBuilder();
                int times = stack.pop();
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                res.push(res.pop()+sb.toString());
            //在‘[’ 和‘]’之间的字符串相加
            }else {
                res.push(res.pop() + c);
            }
            i++;
        }

        return res.pop();
    }
```

## 括号

LeetCode 20 Valid Parentheses

给定字符串，只包含'()','[]','{}',求是否成对出现

```java
Input: "()"
Output: true
Input: "()[]{}"
Output: true
Input: "(]"
Output: false
```

用stack实现，出现'(','[','{'时，将相对应的反括号压入栈

```java
 	public boolean isValid(String s) {
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
```

## 两个栈实现一个队列

[newcoder]([https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking))

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

```java
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
```

## 两个栈保存最小元素

[newcoder]([https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking))

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

解：使用两个栈保存，stack1保存所有的数据内容，stack2保存对比入栈stack1值，当前值是最小值。

```java
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
```

## 入栈顺序与弹出顺序

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

[newcoder]([https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking))

使用一个栈来模拟这个过程;

使用pushA的元素入栈，每次入栈判断栈顶元素和出栈数组内容是否相同。如果不相同，继续入栈；如果相同，元素出栈并继续判断栈顶元素与出栈数组内容相同？

```JAVA
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
```

















































