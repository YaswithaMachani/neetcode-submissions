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
        void union(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx==rooty){
                return;
            }
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
            count--;
        }
        int getCount(){
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge:edges) {
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount();
    }
}
