class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(min, val);
        }
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) {
            min = 0;
        } else {
            min = minStack.peek();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
