class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp [] = new boolean [s.length()+1];
        dp[s.length()]=true;

        for(int i  = s.length()-1;i>=0;i--){
             boolean ans = false;

            for(int j =0;j<wordDict.size();j++){
                String w = wordDict.get(j);
                if(w.equals(s.substring(i,w.length()>s.length()-i?s.length():i+w.length()))){
                    ans = ans || dp[i+wordDict.get(j).length()];
                }
            }
            dp[i]= ans;
        }

        return dp[0];
    }
}