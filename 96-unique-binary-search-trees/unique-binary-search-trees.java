class Solution {
    public int numTrees(int n) {
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        return util(n,dp);
    }
    public int util(int n,int []dp){
        if(n<=1)return 1;
        int ans =0;
        if(dp[n]!=-1)return dp[n];
        for(int i=1 ;i<=n;i++){
            ans += util(i-1,dp)*util(n-i,dp);
        }
        return dp[n]=ans;
    }
}