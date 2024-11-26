class Solution {
    public int compress(char[] chars) {
        String ans="";
        for(int i=0;i<chars.length;i++){
        int count =0;
        char ch = chars[i];
        while(i<chars.length && ch==chars[i]){
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