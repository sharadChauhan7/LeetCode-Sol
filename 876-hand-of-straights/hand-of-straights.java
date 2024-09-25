class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i:hand){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        int[] sortedKeys = new int[freq.size()];
        int index = 0;
        for (int key : freq.keySet()) {
            sortedKeys[index++] = key;
        }

        for(int i=0;i<hand.length/groupSize;i++){
            int prev=-1;
            int count =0;
            for(int j:sortedKeys){
                // System.out.println(j+" "+freq.get(j));
                if(freq.get(j)>0){

                    if(prev==-1){
                        prev=j;
                        // System.out.println(j);
                    }
                    else{
                        // System.out.println(j!=prev+1);
                        if(j!=prev+1){
                            return false;
                        }
                        prev=j;
                    }

                    freq.put(j,freq.get(j)-1);
                    count++;
                    if(count==groupSize)break;
                }
            }
        }
        for (int key : freq.keySet()) {
            if(freq.get(key)!=0)return false;
        }

        return true;
    }
}