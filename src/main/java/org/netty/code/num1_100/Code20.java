package org.netty.code.num1_100;

import java.util.Stack;

public class Code20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 遍历s
        for (char c : s.toCharArray()){
            if (!stack.empty()){
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[')
                    stack.pop();
                else if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else stack.push(c);
            }
            else stack.push(c);
        }
        System.out.println("stack = " + stack);
        return stack.empty();
    }
}
