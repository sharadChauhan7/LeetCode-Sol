import java.util.*;
class Solution {
    public static double helper(String s , double ans,int len,int idx){
        // Base Case
        if(idx>=len || s.charAt(idx)-'0'>9 || s.charAt(idx)-'0'<0 ){
            return ans;
        }
        //
        ans = (double) ans*10+(s.charAt(idx)-'0');
        return helper(s,ans,len,idx+1);
    }
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0 ||(s.length()==1 && s.charAt(0)<=9)){
            return 0;
        }
        int idx=0;
        char sign ='+';
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            sign=s.charAt(0);
            idx=1;
        }
        double ans= helper(s,0,s.length(),idx);
        if(sign=='-'){
            return (int)-ans;
        }
        return (int)ans;
    }
}