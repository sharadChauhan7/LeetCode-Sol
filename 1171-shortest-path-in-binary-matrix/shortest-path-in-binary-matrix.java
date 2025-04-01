class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c= grid[0].length;
        int isV[][] = new int [r][c];
        for(int arr[]:isV){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        isV[0][0]=1;
        if(grid[0][0]==1){
            return -1;
        }
        while(!q.isEmpty()){
            int [] curr =q.remove();
            for(int i=0;i<8;i++){
                int nr = curr[0]+dir[i][0];
                int nc = curr[1]+dir[i][1];
                if(nr>=0 && nr<r && nc >=0 && nc<c && grid[nr][nc]==0){
                    
                    if(isV[nr][nc]>isV[curr[0]][curr[1]]+1){
                        isV[nr][nc]=isV[curr[0]][curr[1]]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return isV[r-1][c-1]!=Integer.MAX_VALUE?isV[r-1][c-1]:-1;
        
    }
}