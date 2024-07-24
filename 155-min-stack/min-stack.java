class MinStack {
    private static ArrayList<Integer> stack ;
    private static int size;
    private static int minVal;

    public MinStack() {
        this.stack= new ArrayList<>();
        this.size=0;
        this.minVal=Integer.MAX_VALUE;
    }
    public void push(int val) {
        size++;
        this.minVal = Math.min(val,minVal);
        this.stack.add(val);
        return;
    }
    
    public void pop() {
        newMin(this.stack.remove(size-1));
        size--;
        return;
    }
    
    public int top() {
        return this.stack.get(size-1);
    }
    
    public int getMin() {
        return minVal;
    }
    private void newMin(int val){
        if(minVal==val){
            this.minVal=Integer.MAX_VALUE;
            for(int i=0;i<size-1;i++){
                this.minVal= Math.min(this.stack.get(i),minVal);
            }
        }
        return;
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