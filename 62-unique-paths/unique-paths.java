class Solution {
    public static int paths=0;
    public int uniquePaths(int m, int n) {
        int dp [][] = new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(m,n,0,0,dp);
        
    }
    public static int helper(int m,int n,int r,int c,int dp[][]){
        if(r>=m || c>=n){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        return dp[r][c]=helper(m,n,r,c+1,dp)+helper(m,n,r+1,c,dp);
    }
}