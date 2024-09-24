class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int dis = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.add(dis);
            if(i>=k-1){
                if(pq.size()>k){
                    pq.remove();
                }
                res[i]=pq.peek();
            }
            else{
                res[i]=-1;
            }
        }
        return res;
    }
}