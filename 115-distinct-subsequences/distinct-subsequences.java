class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int [s.length()+1][t.length()+1];

        for(int i=0;i<=s.length();i++){
            dp[i][t.length()]=1;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j = t.length()-1;j>=0;j--){
                int ans =0;
                if(s.charAt(i)==t.charAt(j)){
                    int take = dp[i+1][j+1];
                    int nottake = dp[i+1][j];
                    ans = take +nottake;
                }
                else{
                    ans = dp[i+1][j];
                }
                dp[i][j]=ans;
            }
        }

        return dp[0][0];
    }
}