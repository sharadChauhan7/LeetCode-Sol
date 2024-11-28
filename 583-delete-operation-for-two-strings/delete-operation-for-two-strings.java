class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int [word1.length()][word2.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return minDistanceUtil(word1,word2,0,0,dp); 
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