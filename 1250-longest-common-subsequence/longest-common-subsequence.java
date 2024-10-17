class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int []num:dp){
            Arrays.fill(num,-1);
        }
        return helper(text1,text2,0,0,dp);

    }

    public int helper(String s1, String s2 , int i, int j,int dp[][]){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int ans =0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans=1+helper(s1,s2,i+1,j+1,dp);
            
        }
        else{
            int l = helper(s1,s2,i+1,j,dp);
            int r = helper(s1,s2,i,j+1,dp);
            ans += Math.max(l,r);
        }
        return dp[i][j]=ans;
    }

}