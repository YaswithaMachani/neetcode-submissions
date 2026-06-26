class Solution {
    class UnionFind{
        int[] parent;
        UnionFind(int n){
            parent=new int[n+1];
            for(int i=1;i<n+1;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(x==parent[x]){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        boolean merge(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx==rooty){
                return false;
            }
            parent[rooty]=rootx;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(!uf.merge(u,v)){
                return edge;
            }
        }
        return new int[0];
    }
}
