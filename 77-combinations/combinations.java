class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),1,n,k);
        return ans;
    }

    public static void helper(List<List<Integer>> ans,List<Integer> curr,int s,int n,int k){
        if(k==0){
            ans.add(new ArrayList(curr));
            return;
        }

        for(int i=s;i<=n;i++){
            curr.add(i);
            helper(ans,curr,i+1,n,k-1);
            curr.remove(curr.size()-1);
        }
    }
}