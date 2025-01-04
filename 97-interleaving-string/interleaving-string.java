class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n= s1.length();
        int m = s2.length();
        if(n+m<s3.length()){
            return false;
        }
        int dp[][] = new int [n+1][m+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }

        return util(s1,s2,s3,0,0,dp);
    }
    public boolean util(String s1, String s2, String s3,int i,int j,int [][]dp){

        if(i>=s1.length() && j >=s2.length()){
            return true;
        }

        if( dp[i][j]!=-1){
            return dp[i][j]==1?true:false;
        }
        
        boolean c1=false,c2=false;
        if( i<s1.length() && i+j<s3.length() && s3.charAt(i+j)== s1.charAt(i)){
            c1 = util(s1,s2,s3,i+1,j,dp);
        }
        if(j<s2.length() && i+j<s3.length() && s3.charAt(i+j)== s2.charAt(j)){
            c2 = util(s1,s2,s3,i,j+1,dp);
        }
        dp[i][j] =  (c1 || c2)?1:0;
        return c1 || c2;
    }
}