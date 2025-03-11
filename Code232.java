import java.util.Queue;
import java.util.Stack;

public class Code232 {
    private Stack<Integer> stack_in;
    private Stack<Integer> stack_out;

    public Code232() {
        this.stack_in = new Stack<>();
        this.stack_out = new Stack<>();
    }

    public void push(int x) {
        stack_in.push(x);
    }

    public int pop() {
        // 1. 检查stack_out栈中是否存在数据
        if (!stack_out.empty()){
            return stack_out.pop();
        }
        // 2. stack_out 为空，判断stack_in是否有数据
        else if (!stack_in.empty()){
            while (!stack_in.empty())
                stack_out.push(stack_in.pop());
            return stack_out.pop();
        }
        // 3. 两个栈中都没有数据
        return Integer.MIN_VALUE;
    }

    public int peek() {
        // 1. 检查stack_out栈中是否存在数据
        if (!stack_out.empty()){
            return stack_out.peek();
        }
        // 2. stack_out 为空，判断stack_in是否有数据
        else if (!stack_in.empty()){
            while (!stack_in.empty())
                stack_out.push(stack_in.pop());
            return stack_out.peek();
        }
        // 3. 两个栈中都没有数据
        return Integer.MIN_VALUE;
    }

    public boolean empty() {
        if (stack_in.empty() && stack_out.empty())
            return true;
        else return false;
    }
}
