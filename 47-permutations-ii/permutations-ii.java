class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        // Add each element from the array to the List
        for (int element : nums) {
            arr.add(element);
        }
        helper(arr,curr,ans);
        return ans;
    }
    public static void helper(List<Integer>nums ,List<Integer> curr,List<List<Integer>>ans){
        if(nums.size()<=0){
            if(!ans.contains(curr)){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        for(int i=0;i<nums.size();i++){
            int num = nums.remove(i);
            curr.add(num);
            helper(nums,curr,ans);
            nums.add(i,num);
            curr.remove(curr.size()-1);
        }
        return;
    }
}