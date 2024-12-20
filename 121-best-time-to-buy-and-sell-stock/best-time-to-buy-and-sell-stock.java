class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int curr = prices[0];

        for(int i:prices){
            if(curr>i){
                curr =i;
            }
            else{
                max = Math.max(max,i-curr);
            }
        }
        return max;

    }
}