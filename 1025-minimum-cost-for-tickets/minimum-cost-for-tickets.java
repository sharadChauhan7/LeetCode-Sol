class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][] = new int [days.length][397];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return mT(days,costs,0,0,dp);
    }
    public int mT(int[] days, int[] costs,int dday,int idx,int [][]dp){
        if(idx >=days.length){
            return 0;
        }
        int ans=0;
        if(dp[idx][dday]!=-1){
            return dp[idx][dday];
        }
        if(days[idx]>=dday){
            int c1 = mT(days,costs,days[idx]+1,idx+1,dp)+costs[0];
            int c2 = mT(days,costs,days[idx]+7,idx+1,dp)+costs[1];
            int c3 = mT(days,costs,days[idx]+30,idx+1,dp)+costs[2];
            ans = Math.min(c1,Math.min(c2,c3));
        }
        else{
            ans = mT(days,costs,dday,idx+1,dp);
        }
        return dp[idx][dday]=ans;
    }
}