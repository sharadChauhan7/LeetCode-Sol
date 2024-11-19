class Solution {
    public int rob(int[] nums) {
        return btup(nums);

    }
    public int btup(int [] nums){
        int num = nums.length;
        int dp[] = new int[num];
        dp[num-1]=nums[num-1];

        for(int i=num-2;i>=0;i--){
            if(i+2>=num){
                dp[i] = Math.max(nums[i],dp[i+1]);
            }
            else{
                dp[i]= Math.max(nums[i]+dp[i+2],dp[i+1]);
            }
        }
        return dp[0];
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