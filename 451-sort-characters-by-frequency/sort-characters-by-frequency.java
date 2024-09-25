class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<HashMap.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->{
            return -(a.getValue()-b.getValue());
        });

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char curr = pq.peek().getKey();
            while(map.get(curr)!=0){
                sb.append(curr);
                map.put(curr,map.get(curr)-1);
                if(map.get(curr)==0)pq.remove();
            }
        }
        return sb.toString();
        
    }
}