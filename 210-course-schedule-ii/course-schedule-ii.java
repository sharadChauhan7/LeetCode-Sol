class Solution {
    static int idx=0;
    public int[] findOrder(int numCourses, int[][] pr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        int inDegree[] = new int [adj.size()];
        for(int i=0;i<pr.length;i++){
            adj.get(pr[i][0]).add(pr[i][1]);
            inDegree[pr[i][1]]++;
        }
        System.out.println(adj);
        // return false;
        Queue<Integer> q = new LinkedList<>();
        

        int ans [] = new int [numCourses];
        idx=numCourses-1;
        for(int i=0;i<adj.size();i++){
           if(inDegree[i]==0){
               q.add(i);
               ans[idx--]=i;
           }
        }
        
            tsUtil(adj,q,inDegree,ans);

            
        return idx>=0?new int[0]:ans;
    }
    static void tsUtil(ArrayList<ArrayList<Integer>> adj,Queue<Integer>q,int inDegree[],int []ans){
        
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0;i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                    ans[idx--]=neigh;
                }
            }
        }
        return;
    }
}