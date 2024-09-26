class Solution {
    public class Info implements Comparable<Info>{
        int sum;
        int idx1;
        int idx2;

        Info(int sum,int idx1,int idx2){
            this.sum=sum;
            this.idx1=idx1;
            this.idx2=idx2;
        }
        @Override
        public int compareTo(Info pair){
            return this.sum-pair.sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0;i<Math.min(nums1.length,k);i++){
                pq.add(new Info(nums1[i]+nums2[0],i,0));      
        }
        List<List<Integer>> ans = new ArrayList<>();
        // for(Info val :pq){
        //     System.out.println(val.sum);
        // }
        while(!pq.isEmpty() && k-->0){
            List<Integer> res = new ArrayList<>();
            Info curr = pq.remove();
            res.add(nums1[curr.idx1]);
            res.add(nums2[curr.idx2]);
            ans.add(res);
            if(curr.idx2+1<=nums2.length-1){
                pq.add(new Info(nums1[curr.idx1]+nums2[curr.idx2+1],curr.idx1,curr.idx2+1));
            }
        }
        return ans;
    }
}