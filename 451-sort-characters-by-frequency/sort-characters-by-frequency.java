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
            HashMap.Entry<Character,Integer> curr = pq.remove();
            char key = curr.getKey();
            int freq = curr.getValue();

            for(int i=0;i<freq;i++){
                sb.append(key);
            }
        }
        return sb.toString();
        
    }
}