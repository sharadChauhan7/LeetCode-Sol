class Solution {
    public static void combination(int nums[],int t,List<List<Integer>>ans,int sum,List<Integer> sol,int idx){
        // Base case 
        if(sum==t){
            ans.add(new ArrayList<>(sol));
            return;
        }
        else if(idx>=nums.length || sum>t){
            return;
        }
        sol.add(nums[idx]);
        combination(nums,t,ans,sum+nums[idx],sol,idx);
        sol.remove(sol.size()-1);
        combination(nums,t,ans,sum,sol,idx+1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
         combination(candidates,target,ans,0,sol,0);
         return ans;
    }
}