class Solution {
    class DSU{
        int[] parent,rank;
        int nodes;
        public DSU(int n){
            parent=new int[n];
            rank=new int[n];
            nodes=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public int find(int x){
            if(x==parent[x]){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        public boolean union(int x,int y){
            int xx=find(x);
            int yy=find(y);
            if(xx==yy){
                return false;
            }
            nodes--;
            if(rank[xx]>=rank[yy]){
                rank[xx]+=rank[yy];
                parent[yy]=xx;
            }
            else{
                rank[yy]+=rank[xx];
                parent[xx]=yy;
            }
            return true;
        }
        public int numOfprovinces(){
        return nodes;
    }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        return dsu.numOfprovinces();
    }
}