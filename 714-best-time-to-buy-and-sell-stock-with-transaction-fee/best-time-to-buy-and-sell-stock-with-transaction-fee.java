class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int [prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                int ans=0;
                if(j==1){
                    int take = dp[i+1][0]-prices[i];
                    int notTake = dp[i+1][1];
                    ans = Math.max(take,notTake);
                }
                else{
                    int take = dp[i+1][1]+prices[i]-fee;
                    int notTake = dp[i+1][0];
                    ans = Math.max(take,notTake);
                }
                dp[i][j]= ans;
            }
        }
        return dp[0][1];
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