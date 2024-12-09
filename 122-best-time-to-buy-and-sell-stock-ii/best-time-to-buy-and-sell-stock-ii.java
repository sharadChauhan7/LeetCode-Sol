class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int [prices.length][2];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return maxProfitUtil(prices,0,1,dp);
    }

    public int maxProfitUtil(int []prices,int idx,int flag,int dp[][]){
        if(idx>=prices.length){
            return 0;
        }
        int ans =0;
        if(dp[idx][flag]!=-1){
            return dp[idx][flag];
        }
        if(flag==1){
            int take = maxProfitUtil(prices,idx+1,0,dp)-prices[idx];
            int notTake = maxProfitUtil(prices,idx+1,1,dp);
            ans = Math.max(take,notTake);
        }
        else{
            int take = maxProfitUtil(prices,idx+1,1,dp)+prices[idx];
            int notTake = maxProfitUtil(prices,idx+1,0,dp);
            ans = Math.max(take,notTake);
        }
        return dp[idx][flag]= ans;
    }
}