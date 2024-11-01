class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean isV[][] = new boolean [n][m];
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && !isV[0][i]){
                dfs(grid,isV,0,i);
            }
            if(grid[n-1][i]==1 && !isV[n-1][i]){
                dfs(grid,isV,n-1,i);
            }
        }
        for(int i=1;i<n-1;i++){
            if(grid[i][0]==1 && !isV[i][0]){
                dfs(grid,isV,i,0);
            }
            if(grid[i][m-1]==1 && !isV[i][m-1]){
                dfs(grid,isV,i,m-1);
            }
        }
        int count =0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==1 && !isV[i][j]){
                   count+=dfs(grid,isV,i,j);
                }
            }
        }
        return count;
    }

    public int dfs(int grid[][],boolean isV[][],int i,int j){
        if( i>=0 && j>=0 && i<grid.length && j<grid[0].length && !isV[i][j] && grid[i][j]==1){
            isV[i][j]=true;
            int a =dfs(grid,isV,i+1,j);
            int b = dfs(grid,isV,i-1,j);
            int c= dfs(grid,isV,i,j+1);
            int d = dfs(grid,isV,i,j-1);
            return a+b+c+d+1;
        }
        return 0;

    }
}