class Solution {
    public int compress(char[] chars) {
        StringBuilder sb  = new StringBuilder("");

        for(char c :chars){
            sb.append(c);
        }
        String str = sb.toString();
        String ans="";
        for(int i=0;i<str.length();i++){
        int count =0;
        char ch = str.charAt(i);
        while(i<str.length() && ch==str.charAt(i)){
            count++;
            i++;
        }
            if(count>1)ans=(ans+ch+count);
            else ans =ans+ch;
            i--;
        } 
        for(int i=0;i<ans.length();i++){
            chars[i]=ans.charAt(i);
        }
        return ans.length();
    }
}