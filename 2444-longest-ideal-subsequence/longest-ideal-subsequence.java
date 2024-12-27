class Solution {
    public int longestIdealString(String s, int k) {
        int dp[] = new int [150];
        // Arrays.fill(dp,1);
        int max =0;

        for(int ci=0;ci<s.length();ci++){
            int i = s.charAt(ci);
            for(int j=i-k;j<=i+k;j++){
                dp[i] = Math.max(dp[i],dp[j]);
            }
                max = Math.max(max,++dp[i]);
        }
        return max;
    }
}