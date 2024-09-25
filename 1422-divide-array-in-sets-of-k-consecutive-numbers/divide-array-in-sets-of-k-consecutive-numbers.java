class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int h:nums){
           map.put(h,map.getOrDefault(h,0)+1);
        }
        for(int h:nums){
            if(map.get(h)>0){
                for(int j = 0;j<k;j++){
                    int nexthand = h+j;
                     if(map.containsKey(nexthand)&&map.get(nexthand)>0){
                        map.put(nexthand,map.getOrDefault(nexthand,0)-1);
                     }
                     else{
                        return false;
                     }
                }
            }
        }
        return true; 
    }
}