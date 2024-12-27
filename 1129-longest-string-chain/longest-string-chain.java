class Solution {
    public int longestStrChain(String[] nums) {
        int dp [] = new int [nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums,Comparator.comparing(s-> s.length()));
        // for(String a :nums){
        //     System.out.print(a+" ");
        // }
        int max = 1;
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(compareChain(nums[j],nums[i]) && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                }
            }
            if(dp[i]>max){
                    max = dp[i];
                    idx = i;
            }
        }
        return max;

    }
    public boolean compareChain(String s1,String s2){
        if(s2.length()!=s1.length()+1) return false;
        int idx1=0,idx2=0;
        // System.out.println(s1+" "+s2);
        while(idx1<s1.length() && idx2 < s2.length()){
            if(s1.charAt(idx1)==s2.charAt(idx2)){
                idx1++;
                idx2++;
            }
            else{
                idx2++;
            }
        }
        if(idx1==s1.length() && (idx2==s2.length() || idx2==s2.length()-1 )){
            return true;
        }
        return false;
    }
}