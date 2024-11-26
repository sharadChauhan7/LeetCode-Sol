class Solution {
    public String countAndSay(int n) {
    String str = "1";
    if(n==1)return "1";
     for(int k=0;k<n-1;k++){
        String ans="";
        for(int i=0;i<str.length();i++){
        int count =0;
        char ch = str.charAt(i);
        while(i<str.length() && ch==str.charAt(i)){

            count++;
            i++;
        }
            ans=(ans+count)+ch;
            i--;
        } 
        str=ans;
     }
     return str;  
    }
}