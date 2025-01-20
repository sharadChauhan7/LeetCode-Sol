class Solution {
    public boolean canFinish(int numCourses, int[][] pr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pr.length;i++){
            adj.get(pr[i][0]).add(pr[i][1]);
        }
        System.out.println(adj);
        // return false;
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int [adj.size()];
        
        for(int i=0;i<adj.size();i++){
            for(int j =0;j<adj.get(i).size();j++){
                int neigh = adj.get(i).get(j);
                inDegree[neigh]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        

        for(int i=0;i<adj.size();i++){
           if(inDegree[i]==0){
               q.add(i);
               ans.add(i);
           }
        }
            tsUtil(adj,q,inDegree,ans);
            
        return ans.size()==adj.size()?true:false;
    }
    static void tsUtil(ArrayList<ArrayList<Integer>> adj,Queue<Integer>q,int inDegree[],ArrayList<Integer>ans){
        
        while(!q.isEmpty()){
            int curr = q.remove();
        
            for(int i=0;i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                    ans.add(neigh);
                }
            }
        }
        return;
    }
}