class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0];
            int c=cell[1];
            int size=q.size();
            for (int[] d:dir) {
                int nr=r+d[0];
                int nc=c+d[1];
                if (nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==Integer.MAX_VALUE){
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
