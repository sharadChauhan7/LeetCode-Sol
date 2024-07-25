class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(k==num.length()){
            return "0";
        }
        
        for(char i :num.toCharArray()){
            while(!st.isEmpty() && i<st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(i);
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        System.out.println(ans.length());
        ans = ans.reverse();
            int count =0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='0'){   
                count++;
            }
            else{
                break;
            }
        }
        ans.delete(0,count);
        if(ans.length()==0){
            return "0";
        }
        num = ans.toString();
        
        return num;
    }
}