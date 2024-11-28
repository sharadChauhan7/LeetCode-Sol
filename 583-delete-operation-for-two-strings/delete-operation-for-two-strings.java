class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int [word1.length()+1][word2.length()+1];
        int n = word1.length();
        int m = word2.length();
        for(int i=n;i>=0;i--){
            dp[i][m]=n-i;
        }
        for(int i=m;i>=0;i--){
            dp[n][i]=m-i;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans =0;
                if(word1.charAt(i)==word2.charAt(j)){
                    ans =dp[i+1][j+1];
                }
                else{
                    int l = dp[i+1][j];
                    int r = dp[i][j+1];
                    ans = 1+Math.min(l,r);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }

    public int minDistanceUtil(String word1, String word2,int i,int j,int [][]dp){
        // Base Case
        if(i>=word1.length()){
            return word2.length()-j;
        } 
        if(j>=word2.length()){
            return word1.length()-i;
        }
        // Choise
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =0;
        if(word1.charAt(i)==word2.charAt(j)){
            ans =minDistanceUtil(word1,word2,i+1,j+1,dp);
        }
        else{
            int l = minDistanceUtil(word1,word2,i+1,j,dp);
            int r = minDistanceUtil(word1,word2,i,j+1,dp);
            ans = 1+Math.min(l,r);
        }
        return dp[i][j]=ans;
    }
}