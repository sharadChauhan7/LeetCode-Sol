class Solution {

    static int [][]mov = {{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        boolean isV[][] = new boolean [n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                dfsUtil(board,isV,0,i);
            }
            if(board[n-1][i]=='O'){
                dfsUtil(board,isV,n-1,i);
            }
        }
        for(int i=1;i<n-1;i++){
            if(board[i][0]=='O'){
                dfsUtil(board,isV,i,0);
            }
            if(board[i][m-1]=='O'){
                dfsUtil(board,isV,i,m-1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !isV[i][j]){
                    board[i][j]='X';
                }

            }
        }
        return;
    }

    public void dfsUtil(char[][] board,boolean isV[][],int i,int j){
        if(i>=0 && j>=0 && i<board.length && j<board[0].length && !isV[i][j] && board[i][j]=='O' ){
            isV[i][j]=true;
            dfsUtil(board,isV,i+1,j);
            dfsUtil(board,isV,i,j+1);
            dfsUtil(board,isV,i-1,j);
            dfsUtil(board,isV,i,j-1);
        }
        return;
    }

}