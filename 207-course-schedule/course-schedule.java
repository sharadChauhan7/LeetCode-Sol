class Solution {
    static int counter=0;
    public boolean canFinish(int numCourses, int[][] pr) {
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
        

            counter=0;
        for(int i=0;i<adj.size();i++){
           if(inDegree[i]==0){
               q.add(i);
               counter++;
           }
        }
        
            tsUtil(adj,q,inDegree);
            
        return counter==adj.size()?true:false;
    }
    static void tsUtil(ArrayList<ArrayList<Integer>> adj,Queue<Integer>q,int inDegree[]){
        
        while(!q.isEmpty()){
            int curr = q.remove();
        
            for(int i=0;i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                    counter++;
                }
            }
        }
        return;
    }
}