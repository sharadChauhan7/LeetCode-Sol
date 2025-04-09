class Solution {
    class Pair{
        int val;
        int dis;
        Pair(int val,int dis){
            this.val=val;
            this.dis=dis;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        long dis[] = new long[n];
        long ways[] = new long[n];
         Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;
        pq.add(new long[]{0,0});
        int mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            long curr[] = pq.remove();
            int node = (int)curr[0];
            long currdis = curr[1];
            // if (curr.dis > dis[curr.val]) continue;
            for(int i=0;i<adj.get(node).size();i++){
                Pair neigh = adj.get(node).get(i);
                if(currdis+neigh.dis < dis[neigh.val]){
                    dis[neigh.val]=currdis+neigh.dis ;
                    ways[neigh.val] = ways[node];
                    pq.add(new long[]{neigh.val,currdis+neigh.dis});
                }
                else if(currdis+neigh.dis == dis[neigh.val]){
                    ways[neigh.val] = (ways[node] + ways[neigh.val]) % mod;
                }
            }
        }
        return (int)ways[n-1];
    }
}