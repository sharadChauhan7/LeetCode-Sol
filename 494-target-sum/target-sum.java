class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total =0;
        for(int a:nums){
            total+=a;
        }
        return SumWaysUtil(nums,0,target,0);   
    }
    
    public int SumWaysUtil(int [] nums,int idx,int target,int sum){
        if(idx>=nums.length && sum == target){
            return 1;
        }
        if(idx>=nums.length){
            return 0;
        }

        //Choices

        int add = SumWaysUtil(nums,idx+1,target,sum+nums[idx]);
        int sub = SumWaysUtil(nums,idx+1,target,sum-nums[idx]);

        return add+sub;

    
    }
}