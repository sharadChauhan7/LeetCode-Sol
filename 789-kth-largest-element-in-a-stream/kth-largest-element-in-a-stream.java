class KthLargest {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i:nums){
            this.pq.add(i);
            if(this.pq.size()>k){
                pq.remove();
            }
        }
        return;
    }
    
    public int add(int val) {
        this.pq.add(val);
        if(this.pq.size()>k){
            this.pq.remove();
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */