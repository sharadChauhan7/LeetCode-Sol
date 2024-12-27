class Solution {
    static int count =0;
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int [nums.length];
        int count[] = new int [nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                        dp[i] = 1+dp[j];
                        count[i] = count[j];
                }
                else if(nums[i]>nums[j] && dp[i]==dp[j]+1){
                    count[i] += count[j];
                }
            }
            // System.out.println(dp[i]+" ");
            // System.out.print(count[i]+" ");
            max= Math.max(max,dp[i]);
        }
        int ans=0;
        for(int i =0;i<dp.length;i++){
            if(dp[i]==max) ans+=count[i];
        }
        return ans;
    }
}