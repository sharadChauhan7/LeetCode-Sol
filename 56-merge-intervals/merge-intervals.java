class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();

        // int ans [][] = new int[intervals][2];

        for(int i=0;i<intervals.length;i++){
            if(ans.size()==0 || ans.get(ans.size()-1)[1]<intervals[i][0]){
                ans.add(intervals[i]);
            }

            else{
                int temp[]=ans.get(ans.size()-1);
                temp[1]=Math.max(ans.get(ans.size()-1)[1] ,intervals[i][1]);
                ans.set(ans.size()-1,temp);
            }
        }


        return ans.toArray(new int[0][]);
        
    }
}