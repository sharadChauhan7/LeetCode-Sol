class Solution {
    public boolean bipartUtil(int [][] graph,int [] color,int sidx){
        Queue<Integer> q = new LinkedList<>();
        q.add(sidx);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(color[curr]==-1)color[curr]=0;

            for(int i=0;i<graph[curr].length;i++){
                if(color[graph[curr][i]]==-1){
                    if(color[curr]==0){
                        color[graph[curr][i]]=1;
                    }
                    else{
                        color[graph[curr][i]]=0;
                    }
                    q.add(graph[curr][i]);
                }
                else{
                    if(color[curr]==color[graph[curr][i]])return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            color[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!bipartUtil(graph,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
}