class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int min = Integer.MAX_VALUE;
        int [][]dp = new int [mat.length][4900];

        for(int [] arr :dp){
            Arrays.fill(arr,-1);
        }

        return helper(mat,0,0,target,dp,0);
    }

    public int helper(int[][] mat, int r,int c,int target,int[][] dp,int sum){

        if(r==mat.length){
            return Math.abs(target-sum);
        }

        if(dp[r][sum]!=-1){
            return dp[r][sum];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            mini = Math.min(helper(mat,r+1,i,target,dp,sum+mat[r][i]),mini);
        }

        return dp[r][sum]=mini;
    }
}