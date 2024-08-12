class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ll = new ArrayList<>();
        int count=0;
        int n= nums.length;
        int i=0;
        while(i<n){
            count++;
            if(count>(n/3)){
                ll.add(nums[i]);
                while(i<n-1 && nums[i]==nums[i+1] ){
                    i++;
                }
            }
            if(i<n-1 && nums[i]!=nums[i+1]){
                count =0;
            }
            i++;
        }
        return ll;
    }
}
