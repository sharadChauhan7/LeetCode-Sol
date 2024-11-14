class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        for(int []arr: dp){
            Arrays.fill(arr,-1);
        }
        for(int ans[]:grid){
            for(int i:ans){
                System.out.print(i);
            }
            System.out.println();
        }
        return helper(grid,0,0,dp);

    }
    public int helper(int[][] grid,int i,int j,int dp[][]){
        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        // Kaam

        int down = helper(grid,i+1,j,dp);
        int right = helper(grid,i,j+1,dp);
        dp[i][j]=Math.min(down,right)+grid[i][j];
        return dp[i][j];
    }
}