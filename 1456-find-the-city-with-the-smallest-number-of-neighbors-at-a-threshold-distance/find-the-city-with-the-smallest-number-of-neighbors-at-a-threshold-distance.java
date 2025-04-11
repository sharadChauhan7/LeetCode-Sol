class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int city[][] = new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j){
                    city[i][j]=0;
                }
                else{
                    city[i][j]=(int)1e9;
                }
            }
        }
        for(int i=0;i<edges.length;i++){
            int r = edges[i][0];
            int c = edges[i][1];
            city[r][c] = edges[i][2]; 
            city[c][r] = edges[i][2];
        }
        int ans=0;
        int anscount=Integer.MAX_VALUE;
        for(int via = 0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    city[i][j] = Math.min(city[i][j],(city[i][via]+city[via][j]));    
                }
            }
        }
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(city[i][j]<=distanceThreshold){
                        count++;
                }
            }
            if(count<=anscount){
                ans=i;
                anscount=count;
            }
        }
        return ans;
    }
}