class Solution {
    public static boolean isVowel(char val){
        if(val=='a' || val =='e' || val =='i' || val =='o' || val =='u'){
            return true;
        }
        return false;
    }
    public long countOfSubstrings(String word, int k) {
        return (helper(word,k)-helper(word,k+1));
    }
    public static long helper(String word,int k){
                HashMap<Character,Integer> map = new HashMap<>();

        int i=0,j=0;
        long count=0,ans=0;
        while(j<word.length()){
            char val=word.charAt(j);
            if(isVowel(val)){
                map.put(val,map.getOrDefault(val,0)+1);
            }
            else{
                count++;
            }

            while(map.size()==5 && count>=k){
                
                    ans+= (long)(word.length()-j);
                        char curr = word.charAt(i);
                        if(map.containsKey(curr)){
                            map.put(curr,map.get(curr)-1);
                            if(map.get(curr)==0){
                                map.remove(curr);
                            }
                        }
                        else{
                            count--;
                        }
                        i++;
            }
            j++;
        }
        return ans;
    }
}