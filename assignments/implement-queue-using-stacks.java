class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(!output.isEmpty()){
            return output.pop();
        }else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(!output.isEmpty()){
            return output.peek();
        }else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.size() == 0) && (output.size() == 0);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//https://leetcode.com/problems/implement-queue-using-stacks/