class MinStack {
    Deque<Integer> stack;
    Queue<Integer> minHeap;
    public MinStack() {
        stack = new ArrayDeque<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minHeap.offer(val);
    }
    
    public void pop() {
        int val = stack.pop();
        minHeap.remove(val);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}

/**

Use an array list
A current top pointer -> that points to the last element
Use a min integer -> that points to the minimum element

*/
