class Solution {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        int dp [][] = new int [coins.length][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        int ans =helper(coins,amount,coins.length-1,dp);
        // if(ans<0)return -1;
        return (ans == Integer.MAX_VALUE-1)?-1:ans;
    }
    public int helper(int []coins,int amount,int i,int dp[][]){

        if(amount<=0 || i<0){
            return (amount==0)?0:Integer.MAX_VALUE-1;
        }

        // Choices
        int ans =-1;
        if(dp[i][amount]!=-1) return dp[i][amount];
         
        if(amount >=coins[i]){
            int take = 1+helper(coins,amount-coins[i],i,dp);
            int notTake = helper(coins,amount,i-1,dp);

            ans = Math.min(take,notTake);
        }
        else{
            ans = helper(coins,amount,i-1,dp);
        }
        return dp[i][amount]= ans;
    }
}