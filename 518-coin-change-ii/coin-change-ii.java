class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int [coins.length][amount+1];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        return changeUtil(coins,amount,0,dp);
    }

    public int changeUtil(int [] coins,int amount,int i,int [][]dp){
        if(amount==0){
            return 1;
        }
        if(i>=coins.length){
            return 0;
        }
        if(dp[i][amount]!=-1)return dp[i][amount];
        int inc=0,exc=0;
        if(coins[i]<=amount){
            inc = changeUtil(coins,amount-coins[i],i,dp);
        }
        exc=changeUtil(coins,amount,i+1,dp);
        return dp[i][amount]=inc+exc;
    }
}