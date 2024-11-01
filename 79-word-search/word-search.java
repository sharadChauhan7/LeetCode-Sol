class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean isV[][] = new boolean [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(findWord(board,word,isV,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean findWord(char[][] board, String word,boolean isV[][],int idx,int i,int j){
        // Base Case
        if(idx>=word.length()){
            return true;
        }
        if(i>=0 && j>=0 && i<board.length && j<board[0].length && !isV[i][j] && board[i][j]==word.charAt(idx)){
            isV[i][j]=true;
            boolean isValid =  findWord(board,word,isV,idx+1,i,j-1)|| findWord(board,word,isV,idx+1,i,j+1)||findWord(board,word,isV,idx+1,i-1,j)||findWord(board,word,isV,idx+1,i+1,j);
            if(!isValid){
                isV[i][j]=false;
            }
            return isValid;
            
        }
        else{
            return false;
        }
    }
}