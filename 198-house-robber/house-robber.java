class Solution {
    public int rob(int[] nums) {
        int dp [] = new int[nums.length];
        Arrays.fill(dp,-1);
        return robUtil(nums,0,dp);

    }

    public int robUtil(int [] nums,int si,int[] dp){
        if(si>=nums.length){
            return 0;
        }
        if(dp[si]!=-1) return dp[si];
        int sum1 =robUtil(nums,si+1,dp);
        int sum2 =robUtil(nums,si+2,dp);
        

        return dp[si]=Math.max(sum1,nums[si]+sum2);

    }

}