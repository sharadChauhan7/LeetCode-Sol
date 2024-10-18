class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] isV = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    isV[i][j]= true;
                    q.add(new int[]{i,j});
                }
            }
        }
        q.add(new int []{-1,-1});
        int time =-1;
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int curr[] = q.remove();
            if(curr[0]==-1){
                time++;
                if(q.isEmpty()){
                    break;
                }
                q.add(curr);
                continue;
            }

            for(int i=0;i<4;i++){
                int r = curr[0]+dir[i][0];
                int c = curr[1]+dir[i][1];
                if(r >=0 && r <n && c >=0 && c <m){
                    if(grid[r][c]==1 && !isV[r][c]){
                        isV[r][c]=true;
                        grid[r][c] = 2;
                        q.add(new int []{r,c});
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}