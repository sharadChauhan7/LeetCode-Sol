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
            if(!ans.contains(sol)){
                combination(nums,t,ans,sum+nums[idx],new ArrayList<>(sol),idx+1);
            }
            while(idx+1<nums.length && nums[idx]==nums[idx+1]){
                idx++;
            }
            sol.remove(sol.size()-1);
            combination(nums,t,ans,sum,sol,idx+1);
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(candidates);
         combination(candidates,target,ans,0,sol,0);
         return ans;
    }
}