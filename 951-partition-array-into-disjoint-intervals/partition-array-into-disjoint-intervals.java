class Solution {
    public int partitionDisjoint(int[] nums) {
        int l=0;
        int r=1;
        int max=nums[0];
        int currmax = nums[0];
        while(r<nums.length){
            if(max<=nums[r]){
                currmax  = Math.max(currmax,nums[r]);
                r++;
            }
            else{
                max = Math.max(currmax,nums[r]);
                currmax = Math.max(currmax,nums[r]);
                l=r;
                r++;
            }
        }
        return l+1;
    }
}