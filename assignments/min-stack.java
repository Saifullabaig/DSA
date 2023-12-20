class MinStack {

    Stack<Integer> pushStack;
    Stack<Integer> minStack;
    public MinStack() {
        pushStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        pushStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(pushStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        pushStack.pop();
    }
    
    public int top() {
        return pushStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */