class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int peri=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    peri+=dfs(grid,i,j,m,n);
                }
            }
        }
        return peri;
    }
    public static int dfs(int[][] grid,int i,int j,int m,int n){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0){
            return 1;
        }
        if(grid[i][j]==-1){
            return 0;
        }
        grid[i][j]=-1;
        int count=0;
        count+=dfs(grid,i+1,j,m,n);
        count+=dfs(grid,i-1,j,m,n);
        count+=dfs(grid,i,j+1,m,n);
        count+=dfs(grid,i,j-1,m,n);
        return count;
    }
}