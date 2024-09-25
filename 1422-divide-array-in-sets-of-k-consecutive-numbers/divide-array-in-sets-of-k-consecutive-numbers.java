class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int i:map.keySet()){
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int first = pq.peek();
            for(int i=first;i<first+k;i++){
                if(!map.containsKey(i))return false;
                else{
                    map.put(i,map.get(i)-1);
                    if(map.get(i)==0){
                        int val= pq.remove();
                        if(val!=i)return false;
                    }
                }
            }
        }
        return true;
    }
}