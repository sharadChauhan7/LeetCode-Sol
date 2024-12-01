class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m = text2.length();
        int dp[][] = new int [n+1][m+1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans =0;
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    int l = dp[i][j+1];
                    int r = dp[i+1][j];
                    dp[i][j]=Math.max(l,r);
                }
            }
        }
        return dp[0][0];

    }

    public int helper(String text1, String text2 ,int i,int j,int dp[][]){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        int ans =0;
        if(text1.charAt(i)==text2.charAt(j)){
            ans=1+helper(text1,text2,i+1,j+1,dp);
        }
        else{
            int l = helper(text1,text2,i,j+1,dp);
            int r = helper(text1,text2,i+1,j,dp);
            ans+=Math.max(l,r);
        }

        return ans;
    }
}