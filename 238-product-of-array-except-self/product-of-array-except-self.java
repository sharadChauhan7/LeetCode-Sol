class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftproduct[] = new int [n];
        int rightproduct[] = new int[n];
        leftproduct[0]=1;
        rightproduct[n-1]=1;
        for(int i=1;i<n;i++){
            leftproduct[i] = leftproduct[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            rightproduct[i] = rightproduct[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            leftproduct[i]=leftproduct[i]*rightproduct[i];
        }
        return leftproduct;
    }
}