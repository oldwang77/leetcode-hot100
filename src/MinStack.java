import java.util.Stack;

class MinStack {
    // 最小栈，维护一个单调队列
    Stack<Integer> stack, stack2;
    Integer minn = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(minn);
    }

    public void push(int x) {
        stack.add(x);
        minn = Math.min(stack2.peek(),x);
        stack2.push(minn);
    }

    public void pop() {
        stack.pop();
        stack2.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
