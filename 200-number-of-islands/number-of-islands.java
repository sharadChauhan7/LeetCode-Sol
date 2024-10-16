class Solution {
    public void findIland(char[][] grid,int i,int j,boolean isV [][]){
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{i,j});
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
            isV[i][j]=true;
        while(!q.isEmpty()){
            int [] curr = q.remove();
            int r=curr[0],c=curr[1];
            for(int k=0;k<4;k++){
                if(r+delrow[k]>=0 && c+delcol[k]>=0 && r+delrow[k]<grid.length && c+delcol[k]<grid[0].length){
                    if(grid[r+delrow[k]][c+delcol[k]]=='1' && !isV[r+delrow[k]][c+delcol[k]]){
                        isV[r+delrow[k]][c+delcol[k]]=true;
                        q.add(new int[]{r+delrow[k],c+delcol[k]});
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        boolean isV [][] = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !isV[i][j]){
                    findIland(grid,i,j,isV);
                    count++;
                }
            }
        }
        return count;
    }
}