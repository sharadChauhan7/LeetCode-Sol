class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length; 
        boolean isV[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,isV);
            }
            if(board[i][m-1]=='O'){
                dfs(board,i,m-1,isV);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i,isV);
            }
            if(board[n-1][i]=='O'){
                dfs(board,n-1,i,isV);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !isV[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board, int r,int c,boolean [][]isV){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!='O'||isV[r][c]){
            return;
        }
        isV[r][c] = true;   
        dfs(board,r,c+1,isV);
        dfs(board,r+1,c,isV);
        dfs(board,r-1,c,isV);
        dfs(board,r,c-1,isV);
    }
}