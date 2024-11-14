class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int [][]dp = new int [matrix.length][matrix[0].length];

        for(int [] arr :dp){
            Arrays.fill(arr,100000);
        }

        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min,helper(matrix,0,i,dp));
        }
        return min;
    }
    public int helper(int [][] matrix,int i,int j,int [][]dp){
        if(j>=matrix.length || j<0 ){
            return Integer.MAX_VALUE;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=100000){
            return dp[i][j];
        }
        int ld = helper(matrix,i+1,j-1,dp);
        int d = helper(matrix,i+1,j,dp);
        int rd = helper(matrix,i+1,j+1,dp);
        return dp[i][j]=Math.min(Math.min(ld,d),rd)+matrix[i][j];
    }
}