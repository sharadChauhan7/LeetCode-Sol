class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n1=btup(nums,0,nums.length-2);
        int n2=btup(nums,1,nums.length-1);
        return Math.max(n1,n2);
        
    }
    public int btup(int [] nums,int si,int ei){
        int num = ei+1;
        int dp[] = new int[num];
        dp[num-1]=nums[num-1];

        for(int i=num-2;i>=si;i--){
            if(i+2>=num){
                dp[i] = Math.max(nums[i],dp[i+1]);
            }
            else{
                dp[i]= Math.max(nums[i]+dp[i+2],dp[i+1]);
            }
        }
        return dp[si];
    }
}