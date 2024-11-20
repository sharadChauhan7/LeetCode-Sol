class Solution {
    public int uniquePaths(int m, int n) {
        int dp [][] = new int[m][n];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return btmup(m,n);
        
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
    public int btmup(int m,int n){
        int dp[][] = new int[m][n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 || j==n-1){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}