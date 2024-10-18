class Solution {
    public int countBattleships(char[][] grid) {
                int n = grid.length;
        int m = grid[0].length;
        boolean [][] isV = new boolean[n][m];
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X' && !isV[i][j]){
                    count++;
                    isV[i][j]= true;
                    bfs(grid,isV,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char [][]grid, boolean isV[][],int l,int p){
                Queue<int[]> q = new LinkedList<>();
                                int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
                q.add(new int[]{l,p});

            while(!q.isEmpty()){
            int curr[] = q.remove();

            for(int i=0;i<4;i++){
                int r = curr[0]+dir[i][0];
                int c = curr[1]+dir[i][1];
                if(r >=0 && r <n && c >=0 && c <m){
                    if(grid[r][c]=='X' && !isV[r][c]){
                        isV[r][c]=true;
                        q.add(new int []{r,c});
                    }
                }
            }
        }
    return;
    }
}