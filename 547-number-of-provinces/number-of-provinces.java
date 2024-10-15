class Solution {
    class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest= dest;
        }
    }
    public ArrayList<Edge> [] buildGraph(int[][] isConnected){

        ArrayList<Edge> [] graph = new ArrayList [isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            ArrayList<Edge> temp = new ArrayList<>();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    temp.add(new Edge(i,j));
                }
            }
            graph[i]=temp;
        }
        return graph;
    }
        public static void bfsUtil(ArrayList<Edge>[] graph ,boolean [] visited,int starting){
        Queue<Integer> q = new LinkedList<Integer>();
        // boolean visited [] = new boolean[graph.length];
        q.add(starting);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                visited[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
        return;
    }
    public static int bfs(ArrayList<Edge>[] graph,int starting){
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
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Edge> graph [] = buildGraph(isConnected);
        return bfs(graph,0);
    }
}