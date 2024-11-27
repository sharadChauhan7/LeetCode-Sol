class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int [s.length()][s.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,s.length()-1,s,dp);
    }

    public int helper(int i,int j, String s,int [][]dp){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =0;
        if(s.charAt(i)==s.charAt(j)){
            ans=2+helper(i+1,j-1,s,dp);
        }
        else{
            int l = helper(i+1,j,s,dp);
            int r = helper(i,j-1,s,dp);
            ans+=Math.max(l,r);
        }
        return dp[i][j]= ans;
    }
}