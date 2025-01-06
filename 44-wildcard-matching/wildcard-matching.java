class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return isMatchUtil(s,p,0,0,dp);
    }

    public boolean isMatchUtil(String s, String p,int i,int j,int[][]dp){
        if(i>=s.length() && j>=p.length()){
            return true;
        }
        if(j>=p.length() && i<s.length()){
            return false;
        }
        if(i>=s.length() && j<p.length()){
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*')return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)return dp[i][j]==1?true:false;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            dp[i][j]=isMatchUtil(s,p,i+1,j+1,dp)?1:0;
            return dp[i][j]==1?true:false;
        }
        else if(p.charAt(j)=='*'){
            dp[i][j]=isMatchUtil(s,p,i,j+1,dp) || isMatchUtil(s,p,i+1,j,dp)?1:0;
            return dp[i][j]==1?true:false;
        }
        dp[i][j]=0;
        return false;
    }
}