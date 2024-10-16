class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n=grid.length;
        int m = grid[0].length;
        boolean isV [][] = new boolean [n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int []{sr,sc});
        isV[sr][sc]=true;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int prev = grid[sr][sc];
        grid[sr][sc]=color;
        while(!q.isEmpty()){
            int curr[] = q.remove();
                        grid[curr[0]][curr[1]]=color;
                        isV[curr[0]][curr[1]]=true;
            for(int k=0;k<4;k++){
                if(curr[0]+delrow[k]>=0 && curr[1]+delcol[k]>=0 && curr[0]+delrow[k]<grid.length && curr[1]+delcol[k]<grid[0].length){
                    if(grid[curr[0]+delrow[k]][curr[1]+delcol[k]]==prev && !isV[curr[0]+delrow[k]][curr[1]+delcol[k]]){
                        q.add(new int []{curr[0]+delrow[k],curr[1]+delcol[k]});
                    }
                }
            }
        }
        return grid;
    }
}