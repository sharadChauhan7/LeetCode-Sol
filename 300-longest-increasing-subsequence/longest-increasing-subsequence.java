class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int [][] dp = new int [nums.length+1][nums.length+2];
        // for(int arr[]:dp){
        //     Arrays.fill(arr,-1);
        // }
        // return lengthOfLISUtil(nums,0,-1,dp);
        for(int idx = nums.length-1;idx>=0;idx--){
            for(int prev = idx-1;prev>=-1;prev--){
                int ans =0;
                int take =0;
                if(prev == -1 || nums[prev]<nums[idx]) {
                    take =1+ dp[idx+1][idx+1];
                }
                int notTake = dp[idx+1][prev+1];

                ans = Math.max(take,notTake);
                dp[idx][prev+1]= ans;
            }
        }
        return dp[0][0];
    }
    public int lengthOfLISUtil(int nums[],int idx,int prev,int [][]dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int ans =0;
        int take =0;
        if(prev == -1 || nums[prev]<nums[idx]) {
            take =1+ lengthOfLISUtil(nums,idx+1,idx,dp);
        }
        int notTake = lengthOfLISUtil(nums,idx+1,prev,dp);

        ans = Math.max(take,notTake);
        return dp[idx][prev+1]= ans;
    }
}