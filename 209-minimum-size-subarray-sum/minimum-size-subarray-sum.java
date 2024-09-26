class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int i=0,j=0;
        long sum=0;
        while(j<nums.length ){
            sum=sum+nums[j];
            if(sum<target){
                j++;
            }
            else{

                while(sum>=target){
                    minlen= Math.min(minlen,j-i+1);
                    sum=sum-nums[i];
                    i++;
                }
                j++;

            }
        }
        if(minlen==Integer.MAX_VALUE){
            return 0;
        }
        return minlen;
    }
}