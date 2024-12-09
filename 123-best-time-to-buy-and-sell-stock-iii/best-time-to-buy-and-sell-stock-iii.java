class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int [prices.length+1][2][3];
        // for(int arr[][]:dp){
        //     for(int []num:arr){
        //         Arrays.fill(num,-1);
        //     }
        // }
        // return maxProfitUtil(prices,0,1,dp,2);

        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                    int ans=0;
                    if(j==1){
                        int take = dp[i+1][0][k]-prices[i];
                        int notTake = dp[i+1][1][k];
                        ans = Math.max(take,notTake);
                    }
                    else{
                        int take = dp[i+1][1][k-1]+prices[i];
                        int notTake = dp[i+1][0][k];
                        ans = Math.max(take,notTake);
                    }
                    dp[i][j][k]=ans;
                }
            }
        }
        return dp[0][1][2];
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