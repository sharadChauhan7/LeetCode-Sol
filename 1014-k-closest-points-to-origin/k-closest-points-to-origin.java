class Solution {
    static class Info implements Comparable<Info>{
        int idx;
        int dis;

        Info(int idx,int dis){
            this.idx=idx;
            this.dis=dis;
        }

        @Override
        public int compareTo(Info p2){
            return this.dis-p2.dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int dis = (int)Math.pow(points[i][0],2) + (int)Math.pow(points[i][1],2);
            pq.add(new Info(i,dis));
        }
        System.out.print(pq.peek().idx);
        int ans [][]= new int[k][2];
        int idx=0;
        while(!pq.isEmpty()&& k-->0){
            ans[idx][0]=points[pq.peek().idx][0];
            ans[idx][1]=points[pq.peek().idx][1];
            pq.remove();
            idx++;
        }
        return ans;
    }
}