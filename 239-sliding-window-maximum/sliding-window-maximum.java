class Solution {

    public class Pair implements Comparable<Pair>{
        int idx;
        int val;

        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
        @Override
        public int compareTo(Pair n){
            return this.val-n.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res [] = new int[nums.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int i=0,j=-1;
        while(j<nums.length-1){
            j++;
            if(j-i<k-1){
                pq.add(new Pair(j,nums[j]));
            }
            else{
                while(!pq.isEmpty()&& pq.peek().idx<i){
                    pq.remove();
                }
                pq.add(new Pair(j,nums[j]));
                res[i]=pq.peek().val;
                i++;
            }
        }
        return res;
    }
}