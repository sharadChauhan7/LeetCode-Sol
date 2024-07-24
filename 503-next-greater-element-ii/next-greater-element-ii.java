class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int size = nums.length;

        for(int i=2*size-1;i>=0;i--){
            if(!st.isEmpty()){
                while(!st.isEmpty() && nums[i%size]>=st.peek()){
                    st.pop();
                }
                if(st.isEmpty()&& i<size){
                    ans[i]=-1;
                }
                else if(i<size){
                    ans[i]=st.peek();
                }
            }
            else{
                if(i<size){
                    ans[i]=-1;
                }
            }
                st.push(nums[i%size]);
        }
        return ans; 
    }
}