class Solution {
    public int[] twoSum(int[] num, int target) {
        int l=0,h=num.length-1;
        while(l<h){
            long sum = num[l]+num[h];
            if(sum==target){
                return new int[]{l+1,h+1};
            }
            else if(sum>target){
                h--;
            }
            else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}