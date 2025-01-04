class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(s,0,dp);
    }

    public int decode(String s,int idx,int []dp){
        if(idx >=s.length()){
            return 1;
        }

        // One
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans =0;
        int one=0,two=0;
        if(s.charAt(idx)-48!=0){
            one = decode(s,idx+1,dp);
        }
        // Two
        if(idx+1<s.length() && s.charAt(idx)!='0'){
            int newNum =  (s.charAt(idx)-48)*10+(s.charAt(idx+1)-48);
            if(newNum>9 && newNum <27){
                two = decode(s,idx+2,dp);
            }
        }
        return dp[idx]=one+two;

    }
}