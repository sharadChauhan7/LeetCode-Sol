class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int count =0;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            for(int i=0;i<adj.get(curr).size();i++){
                int neigh = adj.get(curr).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }
        }
        return count==numCourses;
    }
}