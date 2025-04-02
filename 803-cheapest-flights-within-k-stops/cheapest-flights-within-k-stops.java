class Solution {
    class Pair {
        int node;
        int dis;
        int stop;
        Pair(int node,int dis,int stop){
            this.node = node;
            this.dis = dis;
            this.stop = stop;
        }
        Pair(int node,int dis){
            this.node = node;
            this.dis = dis;
            this.stop = 0;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k=k+1;
        Queue<Pair> pq = new LinkedList<>();
        int dis[] = new int[n];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        // System.out.println(adj);
        pq.add(new Pair(src,0,0));
        dis[src]=0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            for(int i=0;i<adj.get(curr.node).size();i++){
                Pair neigh = adj.get(curr.node).get(i);

                // Relaxing the nodes
                if(curr.dis+neigh.dis<dis[neigh.node] && curr.stop+1<=k){
                    dis[neigh.node]=curr.dis+neigh.dis;
                    pq.add(new Pair(neigh.node,dis[neigh.node],curr.stop+1));
                }
            }
        }
        return dis[dst]!=Integer.MAX_VALUE?dis[dst]:-1;
    }
}