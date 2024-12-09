class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int [prices.length][2][3];
        for(int arr[][]:dp){
            for(int []num:arr){
                Arrays.fill(num,-1);
            }
        }
        return maxProfitUtil(prices,0,1,dp,2);
    }
    public int maxProfitUtil(int []prices,int idx,int flag,int dp[][][],int check){
        if(idx>=prices.length || check == 0){
            return 0;
        }
        int ans =0;
        if(dp[idx][flag][check]!=-1){
            return dp[idx][flag][check];
        }
        if(flag==1){
            int take = maxProfitUtil(prices,idx+1,0,dp,check)-prices[idx];
            int notTake = maxProfitUtil(prices,idx+1,1,dp,check);
            ans = Math.max(take,notTake);
        }
        else{
            int take = maxProfitUtil(prices,idx+1,1,dp,check-1)+prices[idx];
            int notTake = maxProfitUtil(prices,idx+1,0,dp,check);
            ans = Math.max(take,notTake);
        }

        return dp[idx][flag][check]= ans;
    }
}