class Solution {
    public int jump(int[] nums) {
        int dp []= new int [nums.length];
        Arrays.fill(dp,-1);

        return helper(nums,dp,0);
    }
    public int helper(int [] nums,int[]dp,int idx){
        if(idx>=nums.length-1){
            return 0;
        }
        if(nums[idx]==0){
            return 100000;
        }
        int min = 100000;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        for(int i=1;i<=nums[idx];i++){
            min = Math.min(min,helper(nums,dp,idx+i)+1);
        }
        return dp[idx]=min;
    }
}