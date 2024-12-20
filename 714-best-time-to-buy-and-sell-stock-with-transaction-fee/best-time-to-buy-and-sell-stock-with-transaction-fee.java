class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int [prices.length][2];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return maxProfitUtil(prices,fee,0,1,dp);
    }
    public int maxProfitUtil(int []prices,int fee,int idx,int flag,int dp[][]){
        if(idx>=prices.length){
            return 0;
        }
        // Choices
        int ans =0;
        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        if(flag==1){

            int buy = maxProfitUtil(prices,fee,idx+1,0,dp);

            int notBuy  = maxProfitUtil(prices,fee,idx+1,1,dp);

            ans = Math.max(buy-prices[idx],notBuy);
        }
        else{
            int sell = maxProfitUtil(prices,fee,idx+1,1,dp)-fee;

            int notSell  = maxProfitUtil(prices,fee,idx+1,0,dp);

            ans = Math.max(sell+prices[idx],notSell);
        }
        return dp[idx][flag]= ans;
    }
}