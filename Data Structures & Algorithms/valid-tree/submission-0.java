class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        int find(int x){
            if(x==parent[x]){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        boolean union(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx==rooty){
                return false;
            }
            if(rootx!=rooty){
                if(rank[rootx]>rank[rooty]){
                    parent[rooty]=rootx;
                }
                else if(rank[rooty]>rank[rootx]){
                    parent[rootx]=rooty;
                }
                else{
                    parent[rootx]=rooty;
                    rank[rooty]++;
                }
            }
            count--;
            return true;
        }
        int getCount(){
            return count;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf=new UnionFind(n);
        for (int[] edge:edges) {
            int u=edge[0];
            int v=edge[1];
            if(!uf.union(u,v)){
                return false;
            }
        }
        return uf.count==1;
    }
}
