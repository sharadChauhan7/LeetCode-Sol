class Solution {
    public int search(int[] nums, int target) {
        int si =0;
        int ei = nums.length-1;

        while(si<=ei){
            int mid = si+(ei-si)/2;
            int curr = nums[mid];
                // System.out.println(curr);
            if(curr == target){
                return mid;
            }
            else if(curr>=nums[ei]){
                // Zone 1
                if(target>=nums[si] && target <=nums[mid]){
                    ei=mid-1;
                }
                else{
                    si=mid+1;
                }
            }
            else{
                // Zone 2
                if(target<= nums[ei] && target>= nums[mid]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
}