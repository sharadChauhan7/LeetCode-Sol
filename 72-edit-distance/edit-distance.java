class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int [word1.length()+1][word2.length()+1];
        for(int []num:dp){
            Arrays.fill(num,-1);
        }
        return lcsBU(word1,word2,0,0,dp);
    }
    public int lcsBU(String s1, String s2,int i,int j,int [][] dp ){
            // Base Case 
            int ans =0;
            if(i>=s1.length()){
                return s2.length()-j;
            }
            if(j>=s2.length()){
                return s1.length()-i;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            if(s1.charAt(i)==s2.charAt(j)){
                ans = lcsBU(s1,s2,i+1,j+1,dp);
            }
            else{
                int del = lcsBU(s1,s2,i+1,j+1,dp);
                int ins = lcsBU(s1,s2,i+1,j,dp);
                int rep = lcsBU(s1,s2,i,j+1,dp);
                ans = 1+(Math.min(Math.min(ins,del),rep));
            }
            return dp[i][j]=ans ;
    }
}