class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
         Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for(int h:hand){
           map.put(h,map.getOrDefault(h,0)+1);
        }
        for(int h:hand){
            if(map.get(h)>0){
                for(int j = 0;j<groupSize;j++){
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