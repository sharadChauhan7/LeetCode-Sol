class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean isV[][] = new boolean[n][m];
        Queue<int []> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int []{i,j});
                }
            }
        }
        // System.out.println(q.peek()[0]);
        q.add(new int[]{-1,-1});
        int count =0;
        int [][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int [] curr = q.remove();
            if(curr[0]==-1){
                if(q.isEmpty()){
                    break;
                }
                count++;
                q.add(curr);
            }
            else{
                for(int i=0;i<4;i++){
                    int r = curr[0]+dir[i][0];
                    int c = curr[1]+dir[i][1];
                    if(r<n && r>=0 && c<m && c>=0 && grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int []{r,c});
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count =-1;
                }
            }
        }
        return count;
    }
}