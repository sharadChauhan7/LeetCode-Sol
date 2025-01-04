class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[][] = new int [days.length+1][days[days.length-1]+31];

        for(int idx = days.length-1;idx>=0;idx--){
            for(int dday =days[days.length-1]+30 ;dday>=1;dday--){
                int ans =0;
                if(days[idx]>=dday){
                int c1 = dp[idx+1][days[idx]+1]+costs[0];
                int c2 = dp[idx+1][days[idx]+7]+costs[1];
                int c3 = dp[idx+1][days[idx]+30]+costs[2];

                ans = Math.min(c1,Math.min(c2,c3));
                }
                else{
                    ans = dp[idx+1][dday];
                }
                dp[idx][dday]=ans;
            }
        }
        for(int arr[]:dp){
            for(int a:arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        return dp[0][1];
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