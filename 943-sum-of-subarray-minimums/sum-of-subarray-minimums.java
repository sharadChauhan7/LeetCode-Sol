class Solution {
    static long mod = (long)(1e9 +7);
    public int sumSubarrayMins(int[] arr) {
        int prevSm [] = prevSmaller(arr);
        int nextSm [] = nextSmaller(arr);
        long ans =0;
        for(int i=0;i<arr.length;i++){
            int left= i-prevSm[i];
            int right = nextSm[i]-i;
            ans= ans+ ((left*right*1l*arr[i])%mod);
            ans =(ans%mod);
        }
        return (int)ans;
    }
    public int[] nextSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int nextSm[] = new int[A.length];
        
        for(int i=A.length-1;i>=0;i--){
            while(!st.isEmpty()){
                if(A[i]<=A[st.peek()]){
                    st.pop();
                }
                else{
                    break;
                }
            }
            if(!st.isEmpty()){
                nextSm[i]=st.peek();
            }
            else{
                nextSm[i]=A.length;
            }
            st.push(i);
        }
        return nextSm;
    }

    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int nextSm[] = new int[A.length];
        
        for(int i=0;i<A.length;i++){
            while(!st.isEmpty()){
                if(A[i]<A[st.peek()]){
                    st.pop();
                }
                else{
                    break;
                }
            }
            if(!st.isEmpty()){
                nextSm[i]=st.peek();
            }
            else{
                nextSm[i]=-1;
            }
            st.push(i);
        }
        return nextSm;
    }
}