class Solution {
        public class Pair implements Comparable<Pair>{
        int idx;
        int sum;

        Pair(int idx,int sum){
            this.idx=idx;
            this.sum=sum;
        }
        @Override
        public int compareTo(Pair n){
            if(this.sum-n.sum==0){
                return this.idx-n.idx;
            }
            return this.sum-n.sum;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[k];

        for(int i=0;i<mat.length;i++){
            int one=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)one++;
            }
            pq.add(new Pair(i,one));
        }
        for(int i=0;i<k;i++){
            res[i]=pq.peek().idx;
            pq.remove();
        }
        return res;
    }
}