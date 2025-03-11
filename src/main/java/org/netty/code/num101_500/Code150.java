package org.netty.code.num101_500;

import java.util.Stack;

public class Code150 {
    public int evalRPN(String[] tokens) {
        // 边界处理
        if (tokens.length == 0)
            return 0;
        // 生成栈
        Stack<Integer> stack = new Stack<>();
        // 遍历tokens
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int i1 = stack.pop();
                int i2 = stack.pop();
                if (str.equals("+")){
                    stack.push(i1 + i2);
                }
                else if (str.equals("-")){
                    stack.push(i2 - i1);
                }
                else if (str.equals("*")){
                    stack.push(i2 * i1);
                }
                else if (str.equals("/")){
                    stack.push(i2 / i1);
                }
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
