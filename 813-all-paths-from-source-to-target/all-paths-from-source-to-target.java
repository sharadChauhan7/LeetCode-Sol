class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int par [] = new int [graph.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph,par,0,ans);
        return ans;
    }
    public void dfs(int [][]graph,int par[],int curr, List<List<Integer>> ans){
        if(curr == graph.length-1){
             getPath(par,ans);
             return;
        }
        for(int i=0;i<graph[curr].length;i++){
                int neigh = graph[curr][i];
                par[neigh]=curr;
                dfs(graph,par,neigh,ans);
        }
        return;
    }
    public void getPath(int[] par, List<List<Integer>> ans){
        List<Integer> temp = new ArrayList<>();
        int idx=par.length-1;
        while(par[idx]!=idx){
            temp.add(0,idx);
            idx = par[idx];
        }
        temp.add(0,idx);
        ans.add(temp);
        return;
    }
}