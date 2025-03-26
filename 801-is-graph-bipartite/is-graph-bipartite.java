class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int isV [] = new int [n];
        Arrays.fill(isV,-1);
        for(int i=0;i<n;i++){
            if(isV[i]==-1){
                if(!dfs(graph,isV,i,false)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int [][]graph,int[]isV,int curr,boolean color){
            isV[curr] = color?0:1;
            for(int i=0;i<graph[curr].length;i++){
                int val  = graph[curr][i];
                if(isV[val]==isV[curr]){
                    return false;
                }
                if(isV[val]==-1){
                    if(!dfs(graph,isV,val,!color)) return false;
                }
            }
            return true;
    }
}