class Solution {
    public boolean canPartition(int[] arr) {
        int target =0;
        for(int a :arr){
            target+=a;
        }
        if(target%2!=0){
            return false;
        }
        int dp[][] = new int [arr.length+1][target+1];
        for(int num[]:dp){
            Arrays.fill(num,-1);
        }
        return isSubsetSumUtil(arr,target,0,dp,target);
    }
    public boolean isSubsetSumUtil(int arr[], int target,int idx,int dp[][],int total){
        
        if(target*2==total){
            return true;
        }
        
        if(target<total/2){
            return false;
        }
        
        if(idx>=arr.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1?true:false;
        }
        
        boolean ans = isSubsetSumUtil(arr,target,idx+1,dp,total) || isSubsetSumUtil(arr, target-arr[idx], idx+1,dp,total);
        dp[idx][target]=ans?1:0;
        return ans;
        
        
    }
}