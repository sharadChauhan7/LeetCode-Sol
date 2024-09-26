class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Character,Integer> map = new HashMap<>();

        for(char i:tasks){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Queue <Integer> q = new LinkedList<>();
        for(char i :map.keySet()){
            pq.add(map.get(i));
        }

        int time =0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int curr = pq.remove()-1;
                if(curr !=0){
                    q.add(time+n);
                    q.add(curr);
                }
            }
            if(!q.isEmpty()){
                if(q.peek()==time){
                    q.remove();
                    pq.add(q.remove());
                }
            }
        }
        return time;
        
        
    }
}