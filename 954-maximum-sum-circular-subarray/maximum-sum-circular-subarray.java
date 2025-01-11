class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n= nums.length;
        // int arr[] = new int [n*2];
        int max=Integer.MIN_VALUE;
        int sum=0;
        int total=0;
        int min=Integer.MAX_VALUE;
        int sum2=0;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            max=Math.max(max,sum);
            if(sum<0){
                sum=0;
            }
            total+=nums[j];

             sum2+=nums[j];
            min=Math.min(min,sum2);
            if(sum2>0){
                sum2=0;
            }
        }

        int ans= max<0?max:Math.max(max,total-min);
        return ans;
        
    }
}