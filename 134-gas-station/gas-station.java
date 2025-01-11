class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        int n = gas.length;
        int total=0;
        int idx=0;
        for(int i=0;i<n;i++){
            gasSum+=gas[i];
            costSum+=cost[i];
            
            total += gas[i]-cost[i];
            if(total<0){
                total=0;
                idx=i+1;
            }
        }
        if(gasSum<costSum)return -1;
        return idx;

    }
}