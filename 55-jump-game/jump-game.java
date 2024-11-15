class Solution {
    public boolean canJump(int[] nums) {
        int max =0;
        int i=0;
        while(i<nums.length && max>=i){
            max =Math.max(max, nums[i]+i);
            if(max>=nums.length-1) return true;
            i++;
        }
        return false;
    }
}