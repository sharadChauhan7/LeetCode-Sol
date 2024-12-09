class Solution {
    public int maxProfit(int[] prices) {
        int arr[] = new int [2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                int ans=0;
                if(j==1){
                    int take = arr[0]-prices[i];
                    int notTake = arr[1];
                    ans = Math.max(take,notTake);
                }
                else{
                    int take = arr[1]+prices[i];
                    int notTake = arr[0];
                    ans = Math.max(take,notTake);
                }
                arr[j]=ans;
            }
        }
        return arr[1];
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