class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int leftMin [] = new int[len];
        int rightMin [] = new int [len];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<len;i++){
            int curr = heights[i];
            if(st.isEmpty()){
                leftMin[i] = -1;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && curr <= heights[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    leftMin[i] = st.peek();
                }
                else{
                    leftMin[i] = -1;
                }
                st.push(i);
            }
        } 
        while(!st.isEmpty()){st.pop();}
        for(int i=len-1;i>=0;i--){
            int curr = heights[i];
            if(st.isEmpty()){
                rightMin[i] = len;
                st.push(i);
            }
            else{
                while(!st.isEmpty() && curr <= heights[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    rightMin[i] = st.peek();
                }
                else{
                    rightMin[i] = len;
                }
                st.push(i);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int h = heights[i]*(rightMin[i]-(leftMin[i]+1));
            ans = Math.max(ans,h);
        }
        return ans;
    }
}