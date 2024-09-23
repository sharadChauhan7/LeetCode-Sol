class Solution {
    static class Info implements Comparable<Info>{
        String num;
        int freq;

        Info(String num,int freq){
            this.num=num;
            this.freq=freq;
        }
        @Override
        public int compareTo(Info n){
            if(this.freq-n.freq == 0){
                return -this.num.compareTo(n.num);
            }
            return this.freq - n.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<String,Integer> map = new HashMap<>();

        for(String i:words){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(String i:map.keySet()){
            pq.add(new Info(i,map.get(i)));
        }
        List<String> ans = new ArrayList<>();

        while(!pq.isEmpty() && k-->0){
            ans.add(pq.peek().num);
            pq.remove();
        }
        return ans;
    }
}