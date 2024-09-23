class Solution {
    static class Info implements Comparable<Info>{
        int num;
        int freq;

        Info(int num,int freq){
            this.num=num;
            this.freq=freq;
        }
        @Override
        public int compareTo(Info n){
            return this.freq - n.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            pq.add(new Info(i,map.get(i)));
        }
        int ans[] = new int[k];
        int idx=0;
        while(!pq.isEmpty() && k-->0){
            ans[idx++]=pq.peek().num;
            pq.remove();
        }
        return ans;
    }
}