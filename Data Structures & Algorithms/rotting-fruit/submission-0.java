class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else{
                    if(grid[i][j]==1){
                        fresh++;
                    }
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int min=-1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            min++;
            for(int s=0;s<size;s++){
                int[] cell=q.poll();
                int r=cell[0];
                int c=cell[1];
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            } 
        }
        if(fresh!=0){
            return -1;
        }
        return min;
    }
}
