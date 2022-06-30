import java.util.Stack;


/**
 * 实现最小栈
 *
 * api 实现 push pop min(获取最小值)
 */
class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack1 = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (stack1.isEmpty() || stack1.peek() > x) {
            stack1.push(x);
        } else {
            stack1.push(stack1.peek());
        }

    }

    public void pop() {
        stack.pop();
        stack1.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack1.peek();
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