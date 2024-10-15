class Solution {

        public static void bfsUtil(int [][] graph ,boolean [] visited,int starting){
        Queue<Integer> q = new LinkedList<Integer>();
        // boolean visited [] = new boolean[graph.length];
        q.add(starting);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                visited[curr]=true;
                System.out.print(curr+" ");
                // for(int i=0;i<graph[curr].size();i++){
                //     q.add(graph[curr].get(i).dest);
                // }
                for(int i =0;i<graph.length;i++){
                    if(graph[curr][i] == 1){
                        q.add(i);
                    }
                }
            }
        }
        return;
    }
    public static int bfs(int[][] graph,int starting){
        boolean isVisited [] = new boolean[graph.length];
        int count=0;
        for(int i=0;i<graph.length;i++){
            if(!isVisited[i]){
                count++;
                bfsUtil(graph,isVisited, i);
            }
        }
        return count;
    }
    public int findCircleNum(int[][] graph) {
        return bfs(graph,0);
    }
}