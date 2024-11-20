class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]= new int [triangle.size()][triangle.size()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return helper(triangle.size()-1,0,0,triangle,dp);
    }
    public int helper(int i,int r, int c, List<List<Integer>> grid,int dp[][]){
        if(r>i || c>r){
            return Integer.MAX_VALUE;
        }
        if(r==i && c<=r ){
            return grid.get(r).get(c);
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        int n1 = helper(i,r+1,c,grid,dp)+grid.get(r).get(c);
        int n2 = helper(i,r+1,c+1,grid,dp)+grid.get(r).get(c);
        return dp[r][c]=Math.min(n1,n2);
    }
}