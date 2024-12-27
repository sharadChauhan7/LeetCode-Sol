class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp [][] = new int [s1.length()][s2.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return mdsUtil(s1,s2,0,0,dp);

    }
    public int getACI(String s){
        int sum =0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i);
        }
        return sum;
    }
    public int mdsUtil(String s1, String s2,int i,int j,int [][]dp){
        if( i >=s1.length()){
            return getACI(s2.substring(j));
        }
        if( j >= s2.length()){
            return getACI(s1.substring(i));
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int sum=0;
        if(s1.charAt(i)==s2.charAt(j)){
            sum = mdsUtil(s1,s2,i+1,j+1,dp);
        }
        else{
            int ts1=s1.charAt(i)+mdsUtil(s1,s2,i+1,j,dp);
            int ts2=s2.charAt(j)+mdsUtil(s1,s2,i,j+1,dp); 
            sum = Math.min(ts1,ts2);
        }
        return dp[i][j] =sum;
    }
}