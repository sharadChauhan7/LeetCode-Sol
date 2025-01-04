class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[2];

        dp[0] = 1;
        for(int idx = s.length()-1;idx>=0;idx--){
            int ans =0;
            int one=0,two=0;
            
            if(s.charAt(idx)-48!=0){
                one = dp[0];
            }
            // Two
            if(idx+1<s.length() && s.charAt(idx)!='0'){
                int newNum =  (s.charAt(idx)-48)*10+(s.charAt(idx+1)-48);
                if(newNum>9 && newNum <27){
                    two = dp[1];
                }
            }
            dp[1]=dp[0];
            dp[0]=one+two;
        }
        return dp[0];
    }
}