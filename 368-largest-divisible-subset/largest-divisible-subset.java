class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        int hash[] = new int [nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int max = 1;
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            hash[i] = i;
            for(int j = 0;j<i;j++){
                if((nums[i]%nums[j]==0 ||nums[j]%nums[i]==0 ) && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i]>max){
                    max = dp[i];
                    idx = i;
            }
        }
        ArrayList<Integer>arr = new ArrayList<>();
        while(idx!=hash[idx]){
            arr.add(0,nums[idx]);
            idx = hash[idx];
        }
        arr.add(0,nums[idx]);
        return arr;
    }
}