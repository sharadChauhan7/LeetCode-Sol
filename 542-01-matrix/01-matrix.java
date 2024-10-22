class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int []> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        boolean isV [][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j]==0){
                    isV[i][j] = true;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int check[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int [] curr = q.remove();
            ans[curr[0]][curr[1]]=curr[2];
            for(int i=0;i<4;i++){
                int r = curr[0]+check[i][0];
                int c = curr[1]+check[i][1];
                if(r>=0 && c>=0 && r<n && c<m){
                    if(!isV[r][c]){
                        q.add(new int[]{r,c,curr[2]+1});
                        isV[r][c]=true;
                    }
                }
            }

        }
        return ans;
    }
}