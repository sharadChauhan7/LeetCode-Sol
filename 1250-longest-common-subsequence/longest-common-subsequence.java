class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int dp[][] = new int[text1.length()][text2.length()];
        // for(int []num:dp){
        //     Arrays.fill(num,-1);
        // }
        // return helper(text1,text2,0,0,dp);

        return lcsBU(text1,text2);
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
    public int lcsBU(String s1, String s2 ){
        int dp[][] = new int [s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}