class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int [n+1][m+1];
        for(int i=n;i>=0;i--){
            dp[i][m]=n-i;
        }
        for(int i=m;i>=0;i--){
            dp[n][i]=m-i;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans =0;
                if(str1.charAt(i)==str2.charAt(j)){
                    ans = 1+dp[i+1][j+1];
                }
                else{
                    int s1= dp[i+1][j];
                    int s2=  dp[i][j+1];
                    ans = 1+Math.min(s1,s2);
                }
                dp[i][j]=ans;
            }
        }
        int i=0,j=0;
        String s="";
        while(i<=n-1 && j<=m-1){
            if(str1.charAt(i)==str2.charAt(j)){
                s+=str1.charAt(i);
                i++;
                j++;
            }
            else{
                if(dp[i+1][j]<dp[i][j+1]){
                    s+=str1.charAt(i);
                    i++;
                }
                else{
                    s+=str2.charAt(j);
                    j++;
                }
            }
        }
        while(i<=n-1){
            s+=str1.charAt(i);
            i++;
        }
        while(j<=m-1){
            s+=str2.charAt(j);
            j++;
        }
        return s;
    }

    public String scsUtil(String str1, String str2,int i , int j,String [][] dp){

        if(i>=str1.length()){
            return str2.substring(j);
        }
        if(j>=str2.length()){
            return str1.substring(i);
        }
        if(dp[i][j]!="-"){
            return dp[i][j];
        }
        StringBuilder ans =new StringBuilder("");
        if(str1.charAt(i)==str2.charAt(j)){

            ans.append(str1.charAt(i)+scsUtil(str1,str2,i+1,j+1,dp));

        }
        else{
            String s1= scsUtil(str1,str2,i+1,j,dp);
            String s2= scsUtil(str1,str2,i,j+1,dp);
            if(s1.length()<=s2.length()) ans.append(str1.charAt(i)+s1);
            else ans.append(str2.charAt(j)+s2);
        }
        return dp[i][j]= ans.toString();
    }
}