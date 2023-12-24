class MyStack {
    Queue q;
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.peek());
            q.remove();
        }
        
    }
    
    public int pop() {
        return (int) q.remove();
    }
    
    public int top() {
        return (int) q.peek();
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//https://leetcode.com/problems/implement-stack-using-queues/