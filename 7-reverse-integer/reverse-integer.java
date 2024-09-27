class Solution {
    public int reverse(int x) {
        long t = Math.abs(x);
        long answer=0;
        while(t>0){
            long digit = t%10;
            answer=(answer*10)+digit;
            t/=10;
        }
        if(answer>(Math.pow(2,31)-1)){
            answer=0;
        }
        if(x<0){
            return (int)answer*-1;
        }
        return (int)answer;
    }
}