class Solution {
    public int minInsertions(String s) {
        int dp[][] = new int [s.length()][s.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }

        return minInsertions(s,0,s.length()-1,dp);
    }
    public int minInsertions(String s, int i,int j,int [][]dp){
        if(i==j){
            return 0;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =0;
        if(s.charAt(i)==s.charAt(j)){
            ans = minInsertions(s,i+1,j-1,dp);
        }
        else{
            int l = minInsertions(s,i+1,j,dp);
            int r = minInsertions(s,i,j-1,dp);
            ans = 1+Math.min(l,r);
        }
        return dp[i][j]= ans;
    }
}