class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        int len = ast.length;

        for(int i=0;i<len;i++){
            if(ast[i]>0){
                st.push(ast[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && Math.abs(st.peek())<Math.abs(ast[i])){
                        st.pop();
                }
                if(!st.isEmpty()&& st.peek()>0 && Math.abs(st.peek())==Math.abs(ast[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(ast[i]);
                }
            }
        }
        int l = st.size();
        int ans [] = new int[l];
        for(int i=0;i<l;i++){
            ans[l-1-i]= st.pop();
        }
        return ans;
    }
}