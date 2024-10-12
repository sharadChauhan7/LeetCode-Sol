class StockSpanner {
    ArrayList<Integer> stocks;
    ArrayList<Integer> prevGt;
    Stack<Integer> st;
    public StockSpanner() {
        this.stocks= new ArrayList<>();
        this.prevGt= new ArrayList<>();
        this.st = new Stack<>();
        return;
    }
    private void getPrevGt(int price){
        while(!st.isEmpty() && price>=stocks.get(st.peek())){
            st.pop();
        }
        if(st.isEmpty()){
            prevGt.add(-1);
        }
        else{
            prevGt.add(st.peek());
        }
        st.push(stocks.size());
        stocks.add(price);
        return;
    }
    
    public int next(int price) {
        getPrevGt(price);
        int curr = stocks.size()-1;
        int prev = prevGt.get(prevGt.size()-1);
        return curr-prev;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */