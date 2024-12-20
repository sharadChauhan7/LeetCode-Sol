class Solution {
    public int maxProfit(int ne, int[] prices) {
        int dp[][][] = new int [prices.length+1][2][ne+1];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=ne;k++){
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
        return dp[0][1][ne];
    }
}