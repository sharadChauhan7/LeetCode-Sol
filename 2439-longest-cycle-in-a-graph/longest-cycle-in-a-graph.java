class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int in[] = new int [n];
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                in[edges[i]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0) q.add(i);
        }
        boolean isV [] = new boolean [n];
        while(!q.isEmpty()){
            int curr = q.remove();
            isV[curr] = true;
            if(edges[curr]!=-1){
                in[edges[curr]]--;
                if(in[edges[curr]] ==0){
                    q.add(edges[curr]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     System.out.println(i+" "+isV[i]);
        // }
        for(int i=0;i<n;i++){
            int count =-1;
            if(isV[i]==false){
                count=1;
                isV[i] = true;
                int neigh = edges[i];
                while(isV[neigh]!=true){
                    count++;
                    isV[neigh] = true;
                    neigh = edges[neigh];
                }
            }
                max = Math.max(count,max);
        }
        return max;
    }
}