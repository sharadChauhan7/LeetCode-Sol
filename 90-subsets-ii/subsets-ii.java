class Solution {
      public static void helper(int [] nums,List<List<Integer>> ans,List<Integer> curr,int idx){
            // Base Case
            if(idx>=nums.length){
                if(!ans.contains(curr)){
                    ans.add(new ArrayList<>(curr));
                }
                return;
            }
            // Work
            curr.add(nums[idx]);
            helper(nums,ans,curr,idx+1);
            curr.remove(curr.size()-1);
            helper(nums,ans,curr,idx+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,ans,new ArrayList<>(),0);
        return ans;
    }
}