class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp [][] = new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(m,n,0,0,dp,obstacleGrid);
    }
    public static int helper(int m,int n,int r,int c,int dp[][],int grid[][]){
        if(r>=m || c>=n){
            return 0;
        }
        if(grid[r][c]==1){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        return dp[r][c]=helper(m,n,r,c+1,dp,grid)+helper(m,n,r+1,c,dp,grid);
    }
}