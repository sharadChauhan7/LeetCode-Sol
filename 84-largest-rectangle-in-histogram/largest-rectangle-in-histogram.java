class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int next [] = new int [len];
        int prev [] = new int [len];
        Stack<Integer> st = new Stack<>();
        for(int i=len-1;i>=0;i--){
            if(!st.isEmpty()){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    next[i] = st.peek();
                }
                else{
                    next[i] = len;
                }
                st.push(i);
            }
            else{
                st.push(i);
                next[i] = len;
            }
        }
        st = new Stack<>();
        for(int i=0;i<len;i++){
            if(!st.isEmpty()){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    prev[i] = st.peek();
                }
                else{
                    prev[i] = -1;
                }
                st.push(i);
            }
            else{
                st.push(i);
                prev[i] = -1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int ans = heights[i]* (next[i]-(prev[i]+1)); 
            max= Math.max(ans,max);
        }
        // System.out.println();
        // for(int i=0;i<len;i++){
        //     System.out.print(prev[i]+" ");
        // }
        return max;

    }
}