class Solution {
    class Pair{
        int r;
        int c;
        int abs;

        Pair(int r,int c,int abs){
            this.r=r;
            this.c=c;
            this.abs=abs;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.abs-b.abs);
        int r = heights.length;
        int c = heights[0].length;
        int dis[][] = new int [r][c];
        for(int arr[]:dis){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        if(r==1 && c==1){
            return 0;
        }
        pq.add(new Pair(0,0,0));
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            dis[curr.r][curr.c]=curr.abs<dis[curr.r][curr.c]?curr.abs:dis[curr.r][curr.c];
            
            for(int i=0;i<4;i++){
                int nr = curr.r+dir[i][0];
                int nc = curr.c+dir[i][1];
                if(nr>=0 && nr<r && nc>=0 && nc<c ){
                    int absd = Math.abs(heights[nr][nc]-heights[curr.r][curr.c]);
                    if(absd<curr.abs){
                        absd=curr.abs;
                    }
                    if(absd<dis[nr][nc]){
                        pq.add(new Pair(nr,nc,absd));
                    }
                }
            }
        }
        
        return dis[r-1][c-1];

    }
}