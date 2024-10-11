class Solution {
    int mod = (int)1e9+7;
    public long subArrayRanges(int[] arr) {
        int prevSm [] = prevSmaller(arr);
        int nextSm [] = nextSmaller(arr);
        int nextGret[] = nextGreter(arr);
        int prevGret [] = prevGreter(arr);
        long min =0,max=0;
        long ans =0;
        for(int i=0;i<arr.length;i++){
            int sleft= i-prevSm[i];
            int sright = nextSm[i]-i;
            int gright =  nextGret[i]-i;
            int gleft = i-prevGret[i];
            min= (sleft*sright);
            max= (gleft*gright);
            ans +=(max-min)*arr[i];
        }
        System.out.println(ans);
        return ans;
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
    public int[] nextGreter(int[] A) {
        Stack<Integer> st = new Stack<>();
        int nextSm[] = new int[A.length];
        
        for(int i=A.length-1;i>=0;i--){
            while(!st.isEmpty()){
                if(A[i]>A[st.peek()]){
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

    public int[] prevGreter(int[] A) {
        Stack<Integer> st = new Stack<>();
        int nextSm[] = new int[A.length];
        
        for(int i=0;i<A.length;i++){
            while(!st.isEmpty()){
                if(A[i]>=A[st.peek()]){
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