class Solution {
    static boolean isSub=false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m = grid1[0].length;
        boolean isV [][] = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !isV[i][j]){
                    isSub=true;
                    dfsUtil(grid1,grid2,isV,i,j);
                    if(isSub)count++;
                }
            }
        }
        return count;
    }
    public void dfsUtil(int[][] grid1,int[][] grid2,boolean isV[][],int i,int j){
        if(i>=0 && j>=0 && i<grid2.length && j<grid2[0].length && !isV[i][j] && grid2[i][j]==1 ){
            isV[i][j]=true;
            if(grid2[i][j]!=grid1[i][j])isSub=false;
            dfsUtil(grid1,grid2,isV,i+1,j);
            dfsUtil(grid1,grid2,isV,i,j+1);
            dfsUtil(grid1,grid2,isV,i-1,j);
            dfsUtil(grid1,grid2,isV,i,j-1);
        }
        return;
    }
}