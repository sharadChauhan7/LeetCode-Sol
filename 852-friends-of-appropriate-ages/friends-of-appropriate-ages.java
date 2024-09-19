class Solution {
    public int numFriendRequests(int[] age) {
        
        int count=0;
        Arrays.sort(age);

        for(int x=age.length-1;x>=0;x--){
            for(int y=x-1;y>=0;y--){
                if((age[y] > 100 && age[x] < 100) || age[y] > age[x] || age[y] <= (0.5 * age[x] + 7)){
                    break;
                }
                else{
                    if(age[x]==age[y]){
                        count+=2;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        return count;
    }
}