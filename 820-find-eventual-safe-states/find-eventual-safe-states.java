class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,Boolean> map = new HashMap<>();

        boolean isPathV [] = new boolean [graph.length];

        for(int i=0;i<graph.length;i++){
            if(!map.containsKey(i)){
                isCycle(i,graph,map,isPathV);
            }
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        for(int a:map.keySet()){
            if(map.get(a))ans.add(a);
        }
        return ans;
    }
    static boolean isCycle(int curr, int[][] graph, HashMap<Integer,Boolean>map,boolean[] isPath){
        if(map.containsKey(curr) && isPath[curr]){
            return true;
        }
        if(map.containsKey(curr) && !isPath[curr]){
            return false;
        }

        map.put(curr,false);
        isPath[curr] = true;

        for(int i=0;i<graph[curr].length;i++){
            int neigh = graph[curr][i];
            if(isCycle(neigh,graph,map,isPath)){
                return true;
            }
        }
        map.put(curr,true);
        isPath[curr]= false;
        return false;
    }
}