class Solution {
    public boolean canPartition(int[] arr) {
        int target=0;
        for(int a:arr){
            target+=a;
        }
        if(target%2!=0)return false;
        int dp[][] = new int [arr.length+1][target+1];
        for(int num[]:dp){
            Arrays.fill(num,-1);
        }
        return isSubsetSumUtil(arr,target/2,0,dp);
    }
    public boolean isSubsetSumUtil(int arr[], int target,int idx,int dp[][]){
        
        if(target==0){
            return true;
        }
        
        if(target<0){
            return false;
        }
        
        if(idx>=arr.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1?true:false;
        }
        
        boolean ans = isSubsetSumUtil(arr,target,idx+1,dp) || isSubsetSumUtil(arr, target-arr[idx], idx+1,dp);
        dp[idx][target]=ans?1:0;
        return ans;
        
        
    }
}